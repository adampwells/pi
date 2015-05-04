package com.alandstreet;

import junit.framework.TestCase;

public class PiCalculatorTest extends TestCase {

    public void testNthTerm() {

        PiCalculator piCalculator = new PiCalculator();

        assertEquals(1.0, piCalculator.calculateNthTerm(1));
        assertEquals(-0.3333333333333333, piCalculator.calculateNthTerm(2));
        assertEquals(0.2, piCalculator.calculateNthTerm(3));

    }

    public void testIterativePi() {

        PiCalculator piCalculator = new PiCalculator();

        Double calculatedPi = piCalculator.calculateIterative(100000);

        double difference = Math.abs(Math.PI - calculatedPi);

        System.out.println("Math.PI:    " + Math.PI);
        System.out.println("Calculated: " + calculatedPi);
        System.out.println("Difference: " + difference);

        assertTrue(difference < 0.0001);

    }

}