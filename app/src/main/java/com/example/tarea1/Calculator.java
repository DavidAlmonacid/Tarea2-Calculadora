package com.example.tarea1;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double exponent(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double divide(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }

        return a / b;
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
