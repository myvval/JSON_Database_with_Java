package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    Socket clientSocket;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.inputStream = createInputStream();
        this.outputStream = createOutputStream();
        System.out.println("Client started!");
    }

    private DataInputStream createInputStream() throws java.io.IOException{
        return new DataInputStream(clientSocket.getInputStream());
    }

    private DataOutputStream createOutputStream() throws java.io.IOException {
        return new DataOutputStream(clientSocket.getOutputStream());
    }

    public DataInputStream getInputStream() throws java.io.IOException {
        return this.inputStream;
    }

    public DataOutputStream getOutputStream() throws java.io.IOException {
        return this.outputStream;
    }



}
