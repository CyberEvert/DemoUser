package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationServiceTest {

    CalculationService calculationService = new CalculationService();

    // Common variables for reuse
    int positiveA = 10;
    int positiveB = 5;
    int negativeA = -10;
    int negativeB = -5;
    int zero = 0;

    @Test
    public void testAdd(){
        assertEquals(15, calculationService.add(positiveA, positiveB));
        assertEquals(-15, calculationService.add(negativeA, negativeB));
        assertEquals(0, calculationService.add(zero, zero));
    }
    @Test
    public void testSubtract(){
        assertEquals(15, calculationService.subtract(positiveA, positiveB));
        assertEquals(-15, calculationService.subtract(negativeA, negativeB));
        assertEquals(0, calculationService.subtract(zero, zero));
    }
}