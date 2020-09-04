package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReaderImpl implements ClientReader{

    private Socket sockets;
    private BufferedReader br;

    public ClientReaderImpl(Socket sockets) throws IOException {
        this.sockets = sockets;
        br = new BufferedReader(new InputStreamReader(sockets.getInputStream()));
    }

    @Override
    public String readLine() {
        String data;
        try {
            data = br.readLine();
            return data;
        } catch (IOException e) {
        }
        return null;
    }

    public void close() throws IOException {
        br.close();
    }
}
