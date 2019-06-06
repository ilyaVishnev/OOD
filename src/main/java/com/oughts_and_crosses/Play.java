package com.oughts_and_crosses;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {

    private Pair[][] array;
    private String compSign = new String();
    private String playerSign;
    int countWin = 0;
    int size;
    boolean difficult = false;
    private Direction direction = Direction.mainDiagonal;
    private Pair position;

    public Play(int n) {
        array = new Pair[n][n];
        size = array.length;
        position = new Pair(size / 2, size / 2, compSign);
        initializeArray();
    }

    public void initializeArray() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                array[row][column] = new Pair(row, column, "[ ]");
            }
        }
    }

    public void startGame() {
        String[] coordinArray = null;
        String coordinate;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("do you like to play hard, \"yes\" or\"no\" ?");
            String dif = reader.readLine();
            difficult = dif.equals("yes") ? true : false;
            System.out.println("which sign do you like, \"x\" or \"o\" ?");
            playerSign = " " + reader.readLine() + " ";
            compSign = playerSign.equals(" x ") ? " o " : " x ";
            position = new Pair(size / 2, size / 2, compSign);
            System.out.println("do you prefer to be first, \"yes\" or\"no\" ?");
            if (reader.readLine().equals("yes")) {
                outOnConsol();
            } else {
                putOnDesk(this.position);
            }
            while (!(coordinate = reader.readLine()).equals("exit")) {
                Pair pair = getCoordinate(coordinate, playerSign);
                putOnDesk(pair);
                if (isWin(playerSign)) {
                    countWin++;
                    if (countWin == 5) {
                        System.out.print("you're a winner");
                        break;
                    }
                    System.out.println("you've won but you're not a winner yet");
                    initializeArray();
                    outOnConsol();
                }
                letContinue(stopPlayerWin(playerSign), stopPlayerWin(compSign), difficult);
                deadHeat();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void letContinue(Pair pair, Pair secondPair, boolean difficult) {
        if (difficult && pair.value.equals("[ ]")) {
            pair.setValue(compSign);
            position = pair;
            putOnDesk(position);
        } else if (difficult && secondPair.value.equals("[ ]")) {
            secondPair.setValue(compSign);
            position = secondPair;
            putOnDesk(position);
        } else {
            position = takeStap();
            putOnDesk(position);
        }
        if (isWin(compSign)) {
            System.out.println("you've lose");
            countWin = 0;
            initializeArray();
            outOnConsol();
        }
    }

    public Pair takeStap() {
        if (array[position.getX()][position.getY()].value.equals("[ ]")) {
            return position;
        }
        if (canWin(position)) {
            position = getWay(direction, position).get(0);
            position.setValue(compSign);
            return position;
        }
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (array[row][column].value.equals("[ ]")) {
                    position = array[row][column];
                    if (canWin(position)) {
                        position.setValue(compSign);
                        return position;
                    }
                }
            }
        }
        position.setValue(compSign);
        return position;
    }

    public boolean canWin(Pair pair) {
        Direction[] values = Direction.values();
        for (Direction direction : values) {
            List<Pair> pairs = getWay(direction, pair);
            if (pairs != null) {
                this.direction = direction;
                return true;
            }
        }
        return false;
    }

    public boolean isWin(String sign) {
        int countHorizont = 0;
        int countVertic = 0;
        int countMainDiag = 0;
        int countSecDiag = 0;
        boolean isWin = false;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (array[row][column].value.equals(sign)) {
                    countHorizont++;
                }
                if (array[column][row].value.equals(sign)) {
                    countVertic++;
                }
                if (column == size - 1 - row && array[row][column].value.equals(sign)) {
                    countSecDiag++;
                }
                if (row == column && array[row][column].value.equals(sign)) {
                    countMainDiag++;
                }
            }
            if (countHorizont == size || countMainDiag == size || countSecDiag == size || countVertic == size) {
                isWin = true;
                break;
            }
            countHorizont = 0;
            countVertic = 0;
        }
        return isWin;
    }

    public Pair stopPlayerWin(String sign) {
        Pair[] emptyPlaceHorizont = new Pair[size];
        Pair[] emptyPlaceVertic = new Pair[size];
        Pair[] emptyPlaceMainDiag = new Pair[size];
        Pair[] emptyPlaceSecDiag = new Pair[size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                emptyPlaceHorizont[column] = array[row][column];
                emptyPlaceVertic[column] = array[column][row];
                if (row == column) {
                    emptyPlaceMainDiag[column] = array[row][column];
                }
                if (column == size - 1 - row) {
                    emptyPlaceSecDiag[column] = array[row][column];
                }
            }
            if (getEmptyPlace(emptyPlaceHorizont, sign).value.equals("[ ]")) {
                return getEmptyPlace(emptyPlaceHorizont, sign);
            }
            if (getEmptyPlace(emptyPlaceVertic, sign).value.equals("[ ]")) {
                return getEmptyPlace(emptyPlaceVertic, sign);
            }
            emptyPlaceHorizont = new Pair[size];
            emptyPlaceVertic = new Pair[size];
        }
        return getEmptyPlace(emptyPlaceMainDiag, sign).value.equals("[ ]") ? getEmptyPlace(emptyPlaceMainDiag, sign) : getEmptyPlace(emptyPlaceSecDiag, sign);
    }

    public Pair getEmptyPlace(Pair[] pairs, String sign) {
        Pair emptyPlaceFalse = new Pair();
        emptyPlaceFalse.setValue(sign);
        Pair emptyPlace = new Pair();
        boolean emptyPlaceFree = true;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].value.equals(sign)) {
                return emptyPlaceFalse;
            }
            if (pairs[i].value.equals("[ ]")) {
                if (emptyPlaceFree) {
                    emptyPlace = pairs[i];
                    emptyPlaceFree = false;
                } else {
                    return emptyPlaceFalse;
                }
            }
        }
        return emptyPlace;
    }

    public List<Pair> getWay(Direction futureDirection, Pair myPosition) {
        List<Pair> result = new ArrayList<>();
        int beginRow;
        int beginColumn;
        int endRow;
        int endColumn;
        switch (futureDirection) {
            case vertical:
                for (int index = 0; index < size; index++) {
                    if (array[index][myPosition.getY()].value.equals(playerSign)) {
                        return null;
                    } else if (!array[index][myPosition.getY()].value.equals(compSign)) {
                        result.add(array[index][myPosition.getY()]);
                    }
                }
                break;
            case horizontal:
                for (int index = 0; index < size; index++) {
                    if (array[myPosition.getX()][index].value.equals(playerSign)) {
                        return null;
                    } else if (!array[myPosition.getX()][index].value.equals(compSign)) {
                        result.add(array[myPosition.getX()][index]);
                    }
                }
                break;
            case mainDiagonal:
                for (int row = 0, column = 0; row < size || column < size; row++, column++) {
                    if (myPosition.getY() != myPosition.getX() && array[row][column].value.equals(playerSign)) {
                        return null;
                    } else if (!array[row][column].value.equals(compSign)) {
                        result.add(array[row][column]);
                    }
                }
                break;
            case secDiagonal:
                for (int row = 0, column = size - 1 - row; row < size || column < size; row++) {
                    if (myPosition.getX() != size - 1 - myPosition.getY() && array[row][column].value.equals(playerSign)) {
                        return null;
                    } else if (!array[row][column].value.equals(compSign)) {
                        result.add(array[row][column]);
                    }
                }
                break;
        }
        return result;
    }

    public void outOnConsol() {
        String result = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result += array[i][j];
            }
            result += "\n";
        }
        System.out.println(result);
    }

    public Pair getCoordinate(String coordinate, String value) {
        String[] coordinArray = coordinate.split(" ");
        int x = Integer.parseInt(coordinArray[0]);
        int y = Integer.parseInt(coordinArray[1]);
        return new Pair(x, y, value);
    }

    public void putOnDesk(Pair pair) {
        array[pair.getX()][pair.getY()] = pair;
        outOnConsol();
    }

    public void deadHeat() {
        boolean dead = true;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (array[row][column].value.equals("[ ]")) {
                    dead = false;
                }
            }
        }
        if (dead) {
            System.out.println("dead heat");
            initializeArray();
            outOnConsol();
        }
    }

    static class Pair {

        int x;
        int y;
        String value = "[ ]";

        Pair() {
        }

        Pair(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return " " + this.value + " ";
        }
    }

    enum Direction {
        horizontal,
        vertical,
        mainDiagonal,
        secDiagonal,
    }

    public static void main(String[] args) {
        Play play = new Play(3);
        play.startGame();
    }
}
