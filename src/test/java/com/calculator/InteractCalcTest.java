package com.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InteractCalcTest {

    private final ByteArrayInputStream in = new ByteArrayInputStream(String.format("12 + 45%sexit", System.getProperty("line.separator")).getBytes());
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
    public void whenAddgetSumm() {
        System.setIn(in);
        InteractCalc calc = new InteractCalc(new Calculator());
        calc.calc();
        assertEquals("result : 57.0" + System.getProperty("line.separator"), out.toString());
    }

    @Test
    public void whenResultThenDiv() {
        System.setIn(new ByteArrayInputStream(String.format("6 * 8%s: 4%sexit", System.getProperty("line.separator"), System.getProperty("line.separator")).getBytes()));
        InteractCalc calc = new InteractCalc(new Calculator());
        calc.calc();
        assertEquals("result : 48.0" + System.getProperty("line.separator") + "result : 12.0" + System.getProperty("line.separator"), out.toString());
    }
}
