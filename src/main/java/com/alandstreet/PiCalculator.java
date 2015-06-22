package com.alandstreet;

import java.util.Date;
import java.util.stream.IntStream;

/**
 * Created by awells on 4/05/2015.
 * <p/>
 * calculates Pi by the infinite series:
 * <p/>
 *
 * 4 * Pi = 1 - 1/3 + 1/5 - 1/7 ...
 *
 * equivalent to:
 *
 * Pi = 4 - 4/3 + 4/5 - 4/7 + ...
 *
 */
public class PiCalculator {

    private static Integer n;

    public static void main(String[] args) {

        System.out.println("\nThis app calculates Pi by the infinite series:");
        System.out.println("\nPi = 4 - 4/3 + 4/5 - 4/7 + ...");

        if (args == null || args.length == 0) {

            System.out.println("\nUsage: java -jar PiCalculator-0.1-SNAPSHOT.jar n\n\nwhere n = number or elements to use to approximate Pi.\n");

        } else {

            try {

                n = Integer.valueOf(args[0]);

                PiCalculator piCalculator = new PiCalculator();

                Double iterativePi = piCalculator.calculateIterative(n);

                System.out.println("\nCalculated Pi iteratively as " + iterativePi + " using " + n + " terms.");
                System.out.println("Compared with Math.PI        " + Math.PI + "\n");

            } catch (Exception e) {

                System.out.println("Usage: java -jar PiCalculator-0.1-SNAPSHOT.jar n\n\nI could not parse argument [" + args[0] + "] as a Java Integer\n");

            }

        }

    }

// the old way
//    public Double calculateIterative(Integer n) {
//
//        Double result = 0D;
//
//        for (int i = 1; i <= n; i++) {
//
//            result += calculateNthTerm(i);
//
//        }
//
//        return 4 * result;
//
//    }

    // the new way, using Streams, Lambdas
    public Double calculateIterative(Integer n) {

        return IntStream.range(1, n).parallel()
                .mapToDouble(num -> calculateNthTerm(num))
                .sum();

    }


    /**
     * Scala - tail recursion
     *

     def pi(terms:Int): Double = {

        def nth(n: Int) = -1 * scala.math.pow(-1, n) * (4 / (2.0 * n - 1))

        def loop(acc: Double, n: Int): Double = {
            if (n == 0) acc
            else loop(acc + nth(n), n-1)
        }

        loop(0, terms)
     }

     *
     */


    /**
     * calculates the n-th term of the infinite series
     * @param n
     * @return Double value representing the term
     */
    public Double calculateNthTerm(Integer n) {

        Double denominator = 2.0 * n - 1;
        Double termSign = -1 * Math.pow(-1, n);
        return termSign * (4 / denominator);

    }

}
