package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWriterImpl implements ClientWriter{

    private Socket socket;
    private PrintWriter pw;

    public ClientWriterImpl(Socket socket) throws IOException {
        this.socket = socket;
        pw = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void print(String message){
        pw.print(message);
        pw.flush();
    }

    @Override
    public void println(String message){
        pw.println(message);
        pw.flush();
    }

    public void close(){
        pw.close();
    }

}
