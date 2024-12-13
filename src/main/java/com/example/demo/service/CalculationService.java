package com.example.demo.service;

public class CalculationService {
    public static void main(String[] args) {
        int a = 5;
        int b = 4;

        int sum = add(a, b);
        int difference = subtract(a, b);
        int product = multiply(a, b);
        int quotient = divide(a, b);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }

    // Method to add two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two numbers (with check for division by zero)
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }
}