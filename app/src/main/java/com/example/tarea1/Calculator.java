package com.example.tarea1;

public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double exponent(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }

        return a / b;
    }
}
