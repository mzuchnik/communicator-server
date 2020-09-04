import java.io.IOException;
import java.net.ServerSocket;

public class ServerTest{

    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(6060);

        Server server = new Server(serverSocket);

        new Thread(server).start();
    }
}
