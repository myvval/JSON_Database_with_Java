package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 2044;
        System.out.println("Server started!");


        try (ServerSocket server = new ServerSocket(port,50, InetAddress.getByName(address))) {
            Socket socket = server.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            String dataFromClient = input.readUTF();
            String stringText = "A record # 12 was sent!";

            System.out.println("Received: "+dataFromClient);
            System.out.println("Sent: A record # 12 was sent!");
            output.writeUTF(stringText);


        } catch (UnknownHostException e) {
            System.err.println("Count not resolve host connection:" + address);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error occured during connection to " +address +"on port"+port);
            e.printStackTrace();
        }








        /*Database db = new Database();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String fullUserInput = scanner.nextLine();
            String[] userInput = fullUserInput.split(" ");
            String operation = userInput[0];
            if (userInput[0].equals("exit")) {break;}
            int index = Integer.parseInt(userInput[1])-1;
            String text = "";
            if (operation.equals("set")) {
                text = String.join(" ", Arrays.copyOfRange(userInput,2,userInput.length));
            }

                if (userInput[0].equals("get")) {
                    System.out.println(db.get(index));
                } else if (userInput[0].equals("set")) {
                    System.out.println(db.set(index,text));
                } else if (userInput[0].equals("delete")) {
                    System.out.println(db.delete(index));
                }



        }*/


    }
}
