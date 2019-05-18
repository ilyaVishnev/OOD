package com.calculator;

public class IngCalculator extends InteractCalc {

    public IngCalculator(Calculator calculator) {
        super(calculator);
        this.operations.add("sin");
        this.operations.add("cos");
        this.operations.add("tg");
        this.operations.add("ctg");
    }

    @Override
    public void getResult() {
        switch (this.operation) {
            case "sin":
                sin();
                break;
            case "cos":
                cos();
                break;
            case "tg":
                tan();
                break;
            case "ctg":
                ctg();
                break;
        }
        super.getResult();
    }

    public Double sin() {
        return super.calculator.result = Math.sin(secondD);
    }

    public Double cos() {
        return super.calculator.result = Math.cos(secondD);
    }

    public Double tan() {
        return super.calculator.result = Math.tan(secondD);
    }

    public Double ctg() {
        return super.calculator.result = 1 / Math.tan(this.secondD);
    }

    public static void main(String[] args) {
        InteractCalc calc = new IngCalculator(new Calculator());
        calc.calc();
    }
}
