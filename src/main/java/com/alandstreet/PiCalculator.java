package com.alandstreet;

import java.util.Date;

/**
 * Created by awells on 4/05/2015.
 * <p/>
 * calculates Pi by the infinite series:
 * <p/>
 * 4 * Pi = 1 - 1/3 + 1/5 - 1/7 + ...
 */
public class PiCalculator {

    private static Integer n;

    public static void main(String[] args) {

        System.out.println("\nThis app calculates Pi by the infinite series:");
        System.out.println("\n4 * Pi = 1 - 1/3 + 1/5 - 1/7 + ...");

        if (args == null || args.length == 0) {

            System.out.println("\nUsage: java -jar PiCalculator-0.1-SNAPSHOT.jar n\n\nwhere n = number or elements to use to approximate Pi.\n");

        } else {

            try {

                n = Integer.valueOf(args[0]);

            } catch (NumberFormatException e) {

                System.out.println("Usage: java -jar PiCalculator-0.1-SNAPSHOT.jar n\n\n I could not parse n as a Java Integer");

            }

            PiCalculator piCalculator = new PiCalculator();

            Date start = new Date();

            Double iterativePi = piCalculator.calculateIterative(n);

            Date iterativeDone = new Date();
            System.out.println("\nCalculated Pi iteratively as " + iterativePi + " using " + n + " terms in " + (iterativeDone.getTime() - start.getTime()) + " milliseconds.");
            System.out.println("Compared with Math.PI        " + Math.PI + "\n");

        }

    }


    public Double calculateIterative(Integer n) {

        Double result = 0D;

        for (int i = 1; i <= n; i++) {

            result += calculateNthTerm(i);

        }

        return 4 * result;

    }

    public Double calculateNthTerm(Integer n) {

        Double denominator = 2D * n - 1;
        Double termSign = -1 * Math.pow(-1, n);
        return termSign * (1 / denominator);

    }

}
