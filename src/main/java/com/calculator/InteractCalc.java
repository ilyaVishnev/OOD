package com.calculator;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InteractCalc {

    private Calculator calculator = new Calculator();
    private Scanner scanner = new Scanner(System.in);
    private List<String> operations = new ArrayList<>(Arrays.asList("+", "-", ":", "*"));
    private Double firstD;
    private String operation;
    private Integer secondI;

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
            secondI = Integer.parseInt(line[1]);
        } else {
            firstD = Double.parseDouble(line[0]);
            secondI = Integer.parseInt(line[2]);
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
                calculator.add(firstD, secondI, (valueOne, valueTwo) -> {
                    return (double) (valueOne + valueTwo);
                }, result -> System.out.println("result : " + result));
                break;
            case "-":
                calculator.subtract(firstD, secondI, (valueOne, valueTwo) -> {
                    return (double) (valueOne - valueTwo);
                }, result -> System.out.println("result : " + result));
                break;
            case ":":
                calculator.div(firstD, secondI, (valueOne, valueTwo) -> {
                    return (double) (valueOne / valueTwo);
                }, result -> System.out.println("result : " + result));
                break;
            case "*":
                calculator.multiple(firstD, secondI, (valueOne, valueTwo) -> {
                    return (double) (valueOne * valueTwo);
                }, result -> System.out.println("result : " + result));
                break;
            default:
                break;
        }
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