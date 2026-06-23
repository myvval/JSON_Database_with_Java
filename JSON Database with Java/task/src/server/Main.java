package server;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 23456;
        System.out.println("Server started!");
        Database database = new Database();

        try (ServerSocket server = new ServerSocket(port,50, InetAddress.getByName(address))) {
            while(true) {
                Socket socket = server.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String json = input.readUTF();

                @SuppressWarnings("unchecked")
                HashMap<String, String> map = new Gson().fromJson(json, HashMap.class);
                String op = "";
                if ("exit".equals(map.get("type"))) {
                    output.writeUTF("OK");
                    output.flush();
                    socket.close();
                    break;
                }
                int index = Integer.parseInt(map.get("index"));

                if ("get".equals(map.get("type"))) {
                    op = database.get(index);
                } else if ("set".equals(map.get("type"))) {
                    op = database.set(index, map.get("message"));
                } else if ("delete".equals(map.get("type"))) {
                    op = database.delete(index);
                }

                output.writeUTF(op);
                output.flush();
                socket.close();

            }
        } catch (UnknownHostException e) {
            System.err.println("Count not resolve host connection:" + address);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error occured during connection to " +address +"on port"+port);
            e.printStackTrace();
        }
    }

}
