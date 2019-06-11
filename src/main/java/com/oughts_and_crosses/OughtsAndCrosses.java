package com.oughts_and_crosses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OughtsAndCrosses {

    Player playerOne;
    Player playerTwo;
    Look look;


    public void startGame() {
        String[] coordinArray = null;
        String coordinate;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("do you like to play hard, \"yes\" or\"no\" ?");
            String dif = reader.readLine();
            boolean difficult = dif.equals("yes") ? true : false;
            System.out.println("put size of field");
            int size = Integer.parseInt(reader.readLine());
            System.out.println("put sign for your player , opponent, empty place");
            String playerOneSign = " " + reader.readLine() + " ";
            String playerTwoSign = " " + reader.readLine() + " ";
            String emptyPlace = " " + reader.readLine() + " ";
            look = new Look(emptyPlace, playerOneSign, playerTwoSign, size);
            playerOne = new Player(look, look.getOught());
            playerTwo = new Player(look, look.getCross());
            System.out.println("wonne see battle of computers");
            if (reader.readLine().equals("yes")) {
                battleOfComputers(difficult);
            } else {
                System.out.println("do you prefer to be first, \"yes\" or\"no\" ?");
                if (reader.readLine().equals("yes")) {
                    look.outOnConsol();
                } else {
                    playerOne.putOnDesk();
                }
                action(reader, difficult);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void action(BufferedReader reader, Boolean difficult) throws IOException {
        String coordinate;
        while (!(coordinate = reader.readLine()).equals("exit")) {
            Pair pair = getCoordinate(coordinate, playerTwo.getMySign());
            playerTwo.setPosition(pair);
            playerTwo.putOnDesk();
            playerTwo.watchForWin();
            letContinue(playerOne.stopPlayerWin(), playerTwo.stopPlayerWin(), difficult);
            playerOne.watchForWin();
            playerOne.deadHeat();
        }
    }

    public void battleOfComputers(Boolean difficult) throws IOException {
        while (true) {
            playerTwo.takeStap();
            playerTwo.putOnDesk();
            if (playerTwo.watchForWin())
                break;
            letContinue(playerTwo.stopPlayerWin(), playerOne.stopPlayerWin(), difficult);
            if (playerOne.watchForWin())
                break;
            playerOne.deadHeat();
        }
    }

    public void letContinue(Pair pair, Pair secondPair, boolean difficult) {
        if (difficult && pair.value.equals(look.getEmpty())) {
            pair.setValue(playerOne.getMySign());
            playerOne.setPosition(pair);
            playerOne.putOnDesk();
        } else if (difficult && secondPair.value.equals(look.getEmpty())) {
            secondPair.setValue(playerOne.getMySign());
            playerOne.setPosition(secondPair);
            playerOne.putOnDesk();
        } else {
            playerOne.takeStap();
            playerOne.putOnDesk();
        }
    }

    public Pair getCoordinate(String coordinate, String value) {
        String[] coordinArray = coordinate.split(" ");
        int x = Integer.parseInt(coordinArray[0]);
        int y = Integer.parseInt(coordinArray[1]);
        return new Pair(x, y, value);
    }

    public static void main(String[] args) {
        OughtsAndCrosses oughtsAndCrosses = new OughtsAndCrosses();
        oughtsAndCrosses.startGame();
    }
}
