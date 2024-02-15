package com.example.tarea1;

import static org.junit.Assert.*;

public class CalculatorTest {
    @org.junit.Test
    public void add() {
        assertEquals(13, Calculator.add(7, 6), 0);
    }

    @org.junit.Test
    public void subtract() {
        assertEquals(4, Calculator.subtract(13, 9), 0);
    }

    @org.junit.Test
    public void multiply() {
        assertEquals(48, Calculator.multiply(6, 8), 0);
    }

    @org.junit.Test
    public void divide() {
        assertEquals(5.5, Calculator.divide(11, 2), 0);
        assertEquals(Double.NaN, Calculator.divide(5, 0), 0);
    }

    @org.junit.Test
    public void exponent() {
        assertEquals(16, Calculator.exponent(2, 4), 0);
        assertEquals(1, Calculator.exponent(5, 0), 0);
    }
}
