package com.calculator;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InteractCalc {

    protected Scanner scanner = new Scanner(System.in);
    protected List<String> operations = new ArrayList<>(Arrays.asList("+", "-", ":", "*"));
    protected Double firstD;
    protected String operation;
    protected Double secondD;
    protected Calculator calculator;

    /**
     * @param calculator
     */
    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * @param input reading from console
     */

    public void fromConsole(String input) {
        String[] line = input.split(" ");
        String first = line[0];
        if (useResult(first)) {
            operation = first;
            firstD = calculator.getResult();
            secondD = Double.parseDouble(line[1]);
        } else {
            firstD = Double.parseDouble(line[0]);
            secondD = Double.parseDouble(line[2]);
            operation = line[1];
        }
    }

    /**
     * @param first
     * @return if result is used
     */

    public boolean useResult(String first) {
        return operations.contains(first);
    }

    /**
     * count result and print on the screen
     */

    public void getResult() {
        switch (operation) {
            case "+":
                calculator.add(firstD, secondD);
                break;
            case "-":
                calculator.subtract(firstD, secondD);
                break;
            case ":":
                calculator.div(firstD, secondD);
                break;
            case "*":
                calculator.multiple(firstD, secondD);
                break;
            default:
                break;
        }
        System.out.println("result : " + calculator.getResult());
    }

    /**
     * start circle
     */

    public void calc() {
        String input;
        while (!(input = scanner.nextLine()).equals("exit")) {
            fromConsole(input);
            getResult();
        }
    }

    public static void main(String[] args) {
        InteractCalc calc = new InteractCalc(new Calculator());
        calc.calc();
    }
}