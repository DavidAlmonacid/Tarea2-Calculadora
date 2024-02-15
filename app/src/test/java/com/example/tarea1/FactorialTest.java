package com.example.tarea1;

import static org.junit.Assert.*;

public class FactorialTest {
    @org.junit.Test
    public void factorial() {
        assertEquals(720, Factorial.factorial(6));
    }
}
