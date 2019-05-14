package com.calculator;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Calculator {

    private double result;

    public void add(Double first, Double second, BiFunction<Double, Double, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public void subtract(Double first, Double second, BiFunction<Double, Double, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public void div(Double first, Double second, BiFunction<Double, Double, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public void multiple(Double first, Double second, BiFunction<Double, Double, Double> op, Consumer<Double> media) {

        this.result = op.apply(first, second);
        media.accept(this.result);
    }

    public void trig(Double first, Function<Double, Double> op, Consumer<Double> media) {
        this.result = op.apply(first);
        media.accept(this.result);
    }

    public double getResult() {

        return this.result;
    }
}
