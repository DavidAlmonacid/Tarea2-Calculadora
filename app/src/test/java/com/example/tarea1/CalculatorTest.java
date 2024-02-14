package com.example.tarea1;

import static org.junit.Assert.*;

public class CalculatorTest {
    @org.junit.Test
    public void add() {
        Calculator calculator = new Calculator();
        assertEquals(13, calculator.add(7, 6), 0);
    }

    @org.junit.Test
    public void subtract() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.subtract(13, 9), 0);
    }

    @org.junit.Test
    public void multiply() {
        Calculator calculator = new Calculator();
        assertEquals(48, calculator.multiply(6, 8), 0);
    }

    @org.junit.Test
    public void divide() {
        Calculator calculator = new Calculator();
        assertEquals(5.5, calculator.divide(11, 2), 0);
        assertEquals(Double.NaN, calculator.divide(5, 0), 0);
    }

    @org.junit.Test
    public void exponent() {
        Calculator calculator = new Calculator();
        assertEquals(16, calculator.exponent(2, 4), 0);
        assertEquals(1, calculator.exponent(5, 0), 0);
    }

    @org.junit.Test
    public void factorial() {
        Calculator calculator = new Calculator();
        assertEquals(720, calculator.factorial(6));
    }

    @org.junit.Test
    public void fibonacci() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.fibonacci(0));
        assertEquals(1, calculator.fibonacci(1));
        assertEquals(1, calculator.fibonacci(2));
        assertEquals(2, calculator.fibonacci(3));
        assertEquals(3, calculator.fibonacci(4));
        assertEquals(5, calculator.fibonacci(5));
        assertEquals(8, calculator.fibonacci(6));
        assertEquals(13, calculator.fibonacci(7));
        assertEquals(21, calculator.fibonacci(8));
    }
}
