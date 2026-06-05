package server;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, world!");
        String[] jsonArr = new String[1000];
        Arrays.fill(jsonArr, "");
        System.out.println(jsonArr.length);

    }

    public static String get(int index, String[] arr) {
        if (arr[index].equals("") || index < 0 || index > arr.length) {
            return "ERROR";
        }
        return arr[index];
    }



}
