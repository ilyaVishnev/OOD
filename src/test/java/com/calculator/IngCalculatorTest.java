package com.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class IngCalculatorTest {

    private final ByteArrayInputStream in = new ByteArrayInputStream(String.format("sin 0.5%sexit", System.getProperty("line.separator")).getBytes());
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream outOrigin = System.out;

    @Before
    public void setOut() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void setOrigin() {
        System.setOut(outOrigin);
    }

    @Test
    public void whenSingetRes() {
        System.setIn(in);
        InteractCalc calc = new IngCalculator(new Calculator());
        calc.calc();
        assertEquals("result : 0.479425538604203" + System.getProperty("line.separator"), out.toString());
    }

    @Test
    public void whenTangThenRes() {
        System.setIn(new ByteArrayInputStream(String.format("tg 0.5%sexit", System.getProperty("line.separator"), System.getProperty("line.separator")).getBytes()));
        InteractCalc calc = new IngCalculator(new Calculator());
        calc.calc();
        assertEquals("result : 0.5463024898437905" + System.getProperty("line.separator"), out.toString());
    }
}
