package server;

import java.security.cert.TrustAnchor;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
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



        }


    }
}
