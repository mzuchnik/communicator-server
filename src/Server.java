import handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{

    private ServerSocket serverSocket;
    private List<ClientHandler> clientHandlerList;
    private ExecutorService pool;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.clientHandlerList = new ArrayList<>();
        this.pool = Executors.newFixedThreadPool(4);
    }


    @Override
    public void run() {
        try {
            while(true) {
                Socket client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client, clientHandlerList);
                clientHandlerList.add(clientHandler);
                pool.execute(clientHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
