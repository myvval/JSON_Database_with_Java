package client;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.InetAddress;
import java.net.Socket;

import com.beust.jcommander.JCommander;

import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import java.net.UnknownHostException;
import com.beust.jcommander.ParameterException;


public class Main {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 23456;



        AppConfig config = new AppConfig();
        try {
            JCommander.newBuilder()
                    .addObject(config)
                    .build()
                    .parse(args);
        } catch (ParameterException e) {
            System.out.println("Parameter expection occured:" + e.getMessage());
            return;
        }



        try (Socket socket = new Socket(InetAddress.getByName(address), port)) {
            ClientHandler handleClient = new ClientHandler(socket);

            DataInputStream input = handleClient.getInputStream();
            DataOutputStream output = handleClient.getOutputStream();

            Map<String,String> map = new HashMap<>();
            map.put("type",config.getType());
            map.put("index",String.valueOf(config.getIndex()));
            map.put("message",config.getMessage());

            if (map.get("type") == null) {
                System.out.printf("Sent: %s%n",map.get("type"));
            } else if (map.get("message").equals("default")) {
                System.out.printf("Sent: %s %s%n", map.get("type"),map.get("index"));
            } else {
                System.out.printf("Sent: %s %s %s%n",map.get("type"),map.get("index"),map.get("message"));
            }
            output.writeUTF(new Gson().toJson(map));
            System.out.println("Received: " + input.readUTF());


        } catch (UnknownHostException e) {
            System.err.println("Count not resolve host connection:" + address);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error occured during connection to " +address +"on port"+port);
            e.printStackTrace();
        }


    }
}
