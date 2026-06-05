package server;

import java.util.Arrays;

public class Database {
    private String[] dbsArr;

    public Database() {
        dbsArr = new String[1000];
        Arrays.fill(dbsArr, "");
    }

    public String set(int index, String text) {
        if (index < 0 || index >= dbsArr.length) {
            return "ERROR";
        }
        dbsArr[index] = text;
        return "OK";
    }

    public String get(int index) {
        if (index < 0 || index > dbsArr.length || dbsArr[index].isEmpty()) {
            return "ERROR";
        }
        return dbsArr[index];
    }

    public String delete(int index) {
        if (index <0 || index > dbsArr.length) {
            return "ERROR";
        }
        if (!dbsArr[index].isEmpty()) {
            dbsArr[index] = "";
        }
        return "OK";
    }

    public void exit() {
        System.exit(0);
    }


}
