package server;

import java.util.Arrays;

public class Database {
    private String[] dbsArr;

    public Database() {
        dbsArr = new String[1000];
        Arrays.fill(dbsArr, "");
    }

    private boolean isIndexValid(int index) {
        return index > 0 && index < dbsArr.length;
    }

    public String set(int index, String text) {
        if (!isIndexValid(index)) {
            return "ERROR";
        }
        dbsArr[index] = text;
        return "OK";
    }

    public String get(int index) {
        if (!isIndexValid(index) || dbsArr[index].isEmpty()) {
            return "ERROR";
        }
        return dbsArr[index];
    }

    public String delete(int index) {
        if (!isIndexValid(index)) {
            return "ERROR";
        }
        dbsArr[index] = "";
        return "OK";
    }




    public void exit() {
        System.exit(0);
    }


}
