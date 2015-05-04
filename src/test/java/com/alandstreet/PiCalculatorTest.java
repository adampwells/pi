package com.alandstreet;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PiCalculatorTest extends TestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Override
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Override
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    public void testNthTerm() {

        PiCalculator piCalculator = new PiCalculator();

        assertEquals(4 * 1/1.0, piCalculator.calculateNthTerm(1));
        assertEquals(4 * -1 / 3.0, piCalculator.calculateNthTerm(2));
        assertEquals(4 * 1/5.0, piCalculator.calculateNthTerm(3));

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

    public void testMainGoodArgs(){

        PiCalculator.main(new String[]{"100"});

        assertEquals("\n" +
                "This app calculates Pi by the infinite series:\n" +
                "\n" +
                "Pi = 4 - 4/3 + 4/5 - 4/7 + ...\n" +
                "\n" +
                "Calculated Pi iteratively as 3.1516934060711157 using 100 terms.\n" +
                "Compared with Math.PI        3.141592653589793\n" +
                "\n", outContent.toString());

    }

    public void testMainBadArgs(){

        PiCalculator.main(new String[]{"sdfsfs"});

        assertEquals("\n" +
                "This app calculates Pi by the infinite series:\n" +
                "\n" +
                "Pi = 4 - 4/3 + 4/5 - 4/7 + ...\n" +
                "Usage: java -jar PiCalculator-0.1-SNAPSHOT.jar n\n\n" +
                "I could not parse argument [sdfsfs] as a Java Integer\n\n", outContent.toString());

    }


}