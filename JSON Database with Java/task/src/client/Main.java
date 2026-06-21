package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
//import java.util.logging.*;




public class Main {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 2044;

        try (Socket socket = new Socket(InetAddress.getByName(address), port)) {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String data = "Give me a record # 12";
            System.out.println("Client started!");
            output.writeUTF(data);
            System.out.println("Sent:"+data);
            System.out.println("Received: "+input.readUTF());



        } catch (UnknownHostException e) {
            System.err.println("Count not resolve host connection:" + address);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error occured during connection to " +address +"on port"+port);
            e.printStackTrace();
        }


    }
}
