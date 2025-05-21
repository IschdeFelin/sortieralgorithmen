package main.java.recursion;

import java.util.Arrays;

/**
 * Klasse zur Berechnung von Fibonacci-Zahlen mit rekursiven Methoden.
 */
public class Fibonacci {
    /**
     * Einstiegspunkt zum Vergleich von rekursiver und memoisierten Fibonacci-Berechnung.
     *
     * @param args Programmargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        long startT = System.currentTimeMillis();
        int result1  =  computeFibonacci(46);
        long endT = System.currentTimeMillis();
        System.out.println("Fibonacci: " + result1 + " (in " + (endT - startT) + "ms)");

        int[] memo = new int[50];
        Arrays.fill(memo, -1);

        long startT2 = System.currentTimeMillis();
        int result2 = computeFibonacciMemoized(46, memo);
        long endT2 = System.currentTimeMillis();
        System.out.println("Fibonacci (memoisiert): " + result2 + " (in " + (endT2 - startT2) + "ms)");
    }

    /**
     * Berechnet die n-te Fibonacci-Zahl rekursiv ohne Optimierung.
     *
     * @param n Die Position in der Fibonacci-Folge (n ≥ 1).
     * @return Die n-te Fibonacci-Zahl.
     */
    public static int computeFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return computeFibonacci(n - 2) + computeFibonacci(n - 1);
        }
    }

    /**
     * Berechnet die n-te Fibonacci-Zahl rekursiv mit Memoization.
     *
     * @param n Die Position in der Fibonacci-Folge (n ≥ 1).
     * @param memoArray Ein Array zur Zwischenspeicherung bereits berechneter Werte.
     * @return Die n-te Fibonacci-Zahl.
     */
    public static int computeFibonacciMemoized(int n, int[] memoArray) {
        if (memoArray[n] != -1) {
            return memoArray[n];
        }
        if (n == 1 || n == 2) {
            memoArray[1] = 1;
            memoArray[2] = 1;
            return 1;
        } else {
            int result = computeFibonacciMemoized(n - 2, memoArray) + computeFibonacciMemoized(n - 1, memoArray);
            memoArray[n] = result;
            return result;
        }
    }
}
