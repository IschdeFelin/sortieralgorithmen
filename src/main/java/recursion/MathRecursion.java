package main.java.recursion;

/**
 * Sammlung rekursiver mathematischer Methoden.
 */
public class MathRecursion {
    /**
     * Einstiegspunkt zum Testen der Methoden.
     *
     * @param args Programmargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        System.out.println("Chip Count: " + countChips(10));
        System.out.println("Power of Two: " + powerOfTwo(10));
        System.out.println("Power: " + power(5, 13));
        System.out.println("Sum: " + computeSum(5));
        System.out.println("Factorial: " + computeFactorial(4));
    }

    /**
     * Berechnet rekursiv die Anzahl an Chips, wobei jeder Schritt 1 Chip entfernt.
     * Praktisch eine Zählfunktion: countChips(n) = n.
     *
     * @param chips Anzahl der Chips.
     * @return Anzahl der Schritte bzw. Chips.
     */
    public static int countChips(int chips) {
        if (chips == 1) {
            return 1;
        } else {
            return countChips(chips - 1) + 1;
        }
    }

    /**
     * Berechnet rekursiv 2 hoch n.
     *
     * @param n Exponent (n ≥ 1).
     * @return 2 hoch n.
     */
    public static int powerOfTwo(int n) {
        if (n == 1) {
            return 2;
        } else {
            return powerOfTwo(n - 1) * 2;
        }
    }

    /**
     * Berechnet rekursiv basis hoch exponent.
     *
     * @param base     Die Basis.
     * @param exponent Der Exponent (exponent ≥ 1).
     * @return base hoch exponent.
     */
    public static int power(int base, int exponent) {
        if (exponent == 1) {
            return base;
        } else {
            return power(base, exponent - 1) * base;
        }
    }

    /**
     * Berechnet rekursiv die Summe aller Zahlen von 1 bis n.
     *
     * @param n Obere Grenze der Summe (n ≥ 1).
     * @return Summe von 1 bis n.
     */
    public static int computeSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return computeSum(n - 1) + n;
        }
    }

    /**
     * Berechnet rekursiv die Fakultät einer natürlichen Zahl.
     *
     * @param n Die Zahl, deren Fakultät berechnet werden soll (n ≥ 1).
     * @return Fakultät von n.
     * @throws IllegalArgumentException wenn n &lt; 1
     */
    public static int computeFactorial(int n) {
//        System.out.println("Methodenaufruf: computeFactorial(" + n + ")");
        if (n < 1) {
            throw new IllegalArgumentException("n muss ≥ 1 sein.");
        }

        if (n == 1) {
            System.out.println("Rückgabe: 1");
            return 1;
        } else {
            int result = computeFactorial(n - 1) * n;
//            System.out.println("Rückgabe: " + result);
            return result;
        }
    }
}
