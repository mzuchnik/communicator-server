package handler;

import model.ClientReader;
import model.ClientReaderImpl;
import model.ClientWriter;
import model.ClientWriterImpl;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable{

    private Socket client;
    private ClientReader clientReader;
    private ClientWriter clientWriter;
    private List<ClientHandler> clientHandlerList;

    public ClientHandler(Socket client, List<ClientHandler> clientHandlerList) throws IOException {
        this.client = client;
        this.clientHandlerList = clientHandlerList;
        clientReader = new ClientReaderImpl(client);
        clientWriter = new ClientWriterImpl(client);
    }

    @Override
    public void run() {

        while(true){
            String data;
            while((data = clientReader.readLine()) != null){
                for (ClientHandler clientHandler : clientHandlerList) {
                    clientHandler.getClientWriter().println(data);
                }
            }
        }
    }

    public Socket getClient() {
        return client;
    }

    public ClientReader getClientReader() {
        return clientReader;
    }

    public ClientWriter getClientWriter() {
        return clientWriter;
    }
}
