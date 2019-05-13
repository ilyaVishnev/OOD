package com.calculator;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {

    private double result;

    public void add(Double first, Integer second, BiFunction<Double, Integer, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public void subtract(Double first, Integer second, BiFunction<Double, Integer, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public void div(Double first, Integer second, BiFunction<Double, Integer, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public void multiple(Double first, Integer second, BiFunction<Double, Integer, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public double getResult() {

        return this.result;
    }
}
