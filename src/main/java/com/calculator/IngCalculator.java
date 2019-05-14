package com.calculator;

public class IngCalculator extends InteractCalc {

    /**
     * @param calculator
     */
    public IngCalculator(Calculator calculator) {
        super(calculator);
        this.operations.add("sin");
        this.operations.add("cos");
        this.operations.add("tg");
        this.operations.add("ctg");
    }

    @Override
    public void getResult() {
        super.getResult();
        switch (this.operation) {
            case "sin":
                this.calculator.trig(this.secondD, value -> {
                    return Math.sin(this.secondD);
                }, result -> System.out.println("result : " + result));
                break;
            case "cos":
                this.calculator.trig(this.secondD, value -> {
                    return Math.cos(this.secondD);
                }, result -> System.out.println("result : " + result));
                break;
            case "tg":
                this.calculator.trig(this.secondD, value -> {
                    return Math.tan(this.secondD);
                }, result -> System.out.println("result : " + result));
                break;
            case "ctg":
                this.calculator.trig(this.secondD, value -> {
                    return 1 / Math.tan(this.secondD);
                }, result -> System.out.println("result : " + result));
                break;
        }
    }

    public static void main(String[] args) {
        InteractCalc calc = new IngCalculator(new Calculator());
        calc.calc();
    }
}
