package com.oughts_and_crosses;

import java.util.ArrayList;
import java.util.List;

public class Player {
private Pair[][]array;
    private int size;
    private Pair position;
    private Direction direction = Direction.mainDiagonal;
    private String mySign;
    private String anotherSign;
    private Look look;
    int countWin = 0;

    public Player(Look look, String sign) {
        this.array = look.getArray();
        this.size = array.length;
        this.mySign = sign;
        this.anotherSign = look.getOpposite(mySign);
        position = new Pair(size / 2, size / 2, mySign);
        this.look = look;
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

    public boolean isWin() {
        int countHorizont = 0;
        int countVertic = 0;
        int countMainDiag = 0;
        int countSecDiag = 0;
        boolean isWin = false;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (array[row][column].value.equals(mySign)) {
                    countHorizont++;
                }
                if (array[column][row].value.equals(mySign)) {
                    countVertic++;
                }
                if (column == size - 1 - row && array[row][column].value.equals(mySign)) {
                    countSecDiag++;
                }
                if (row == column && array[row][column].value.equals(mySign)) {
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

    public boolean watchForWin() {
        if (isWin()) {
            countWin++;
            if (countWin == 5) {
                System.out.print("player " + mySign + " is the best");
            } else {
                System.out.println("this time player " + mySign + " won");
            }
            look.initializeDesk();
            look.outOnConsol();
            position = new Pair(size / 2, size / 2, mySign);
            return true;
        }
        return false;
    }

    public Pair stopPlayerWin() {
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
            if (getEmptyPlace(emptyPlaceHorizont, anotherSign).value.equals(look.getEmpty())) {
                return getEmptyPlace(emptyPlaceHorizont, anotherSign);
            }
            if (getEmptyPlace(emptyPlaceVertic, anotherSign).value.equals(look.getEmpty())) {
                return getEmptyPlace(emptyPlaceVertic, anotherSign);
            }
            emptyPlaceHorizont = new Pair[size];
            emptyPlaceVertic = new Pair[size];
        }
        return getEmptyPlace(emptyPlaceMainDiag, anotherSign).value.equals(look.getEmpty()) ? getEmptyPlace(emptyPlaceMainDiag, anotherSign) : getEmptyPlace(emptyPlaceSecDiag, anotherSign);
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
            if (pairs[i].value.equals(look.getEmpty())) {
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

    public Pair takeStap() {
        if (array[position.getX()][position.getY()].value.equals(look.getEmpty())) {
            return position;
        }
        if (canWin(position)) {
            position = getWay(direction, position).get(0);
            position.setValue(mySign);
            return position;
        }
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (array[row][column].value.equals(look.getEmpty())) {
                    position = array[row][column];
                    if (canWin(position)) {
                        position.setValue(mySign);
                        return position;
                    }
                }
            }
        }
        position.setValue(mySign);
        return position;
    }

    public List<Pair> getWay(Direction futureDirection, Pair myPosition) {
        List<Pair> result = new ArrayList<>();
        switch (futureDirection) {
            case vertical:
                for (int index = 0; index < size; index++) {
                    if (array[index][myPosition.getY()].value.equals(anotherSign)) {
                        return null;
                    } else if (!array[index][myPosition.getY()].value.equals(mySign)) {
                        result.add(array[index][myPosition.getY()]);
                    }
                }
                break;
            case horizontal:
                for (int index = 0; index < size; index++) {
                    if (array[myPosition.getX()][index].value.equals(anotherSign)) {
                        return null;
                    } else if (!array[myPosition.getX()][index].value.equals(mySign)) {
                        result.add(array[myPosition.getX()][index]);
                    }
                }
                break;
            case mainDiagonal:
                if(myPosition.getY() != myPosition.getX())
                    return null;
                for (int row = 0, column = 0; row < size || column < size; row++, column++) {
                    if (array[row][column].value.equals(anotherSign)) {
                        return null;
                    } else if (!array[row][column].value.equals(mySign)) {
                        result.add(array[row][column]);
                    }
                }
                break;
            case secDiagonal:
                if(myPosition.getX() != size - 1 - myPosition.getY())
                    return null;
                for (int row = 0, column = size - 1; row < size; row++,column--) {
                    if (array[row][column].value.equals(anotherSign)) {
                        return null;
                    } else if (!array[row][column].value.equals(mySign)) {
                        result.add(array[row][column]);
                    }
                }
                break;
        }
        return result;
    }

    public boolean deadHeat() {
        boolean dead = true;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (array[row][column].value.equals(look.getEmpty())) {
                    dead = false;
                    return false;
                }
            }
        }
        if (dead) {
            System.out.println("dead heat");
            look.initializeDesk();
            look.outOnConsol();
        }
        return true;
    }

    public void putOnDesk() {
        array[position.getX()][position.getY()] = position;
        look.outOnConsol();
    }

    public String getMySign() {
        return mySign;
    }

    public void setMySign(String mySign) {
        this.mySign = mySign;
    }

    public String getAnotherSign() {
        return anotherSign;
    }

    public void setAnotherSign(String anotherSign) {
        this.anotherSign = anotherSign;
    }

    public Pair getPosition() {
        return position;
    }

    public void setPosition(Pair position) {
        this.position = position;
    }
}
