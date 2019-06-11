package com.oughts_and_crosses;

public class Look {

    String empty;
    String ought;
    String cross;
    Pair[][] array;
    int size;

    public Look(String empty, String ought, String cross, int size) {
        this.empty = empty;
        this.ought = " " + ought + " ";
        this.cross = " " + cross + " ";
        this.size = size;
        array = new Pair[size][size];
        initializeDesk();
    }

    public void initializeDesk() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = new Pair(i, j, empty);
            }
        }
    }

    public String getEmpty() {
        return empty;
    }

    public String getOught() {
        return ought;
    }

    public String getCross() {
        return cross;
    }

    public Pair[][] getArray() {
        return array;
    }

    public String getOpposite(String sign) {
        return sign.equals(cross) ? ought : cross;
    }

    public void outOnConsol() {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                result += array[i][j];
            }
            result += "\n";
        }
        System.out.println(result);
    }
}
