package main.java.recursion;

/**
 * Implementiert das Türme-von-Hanoi-Problem rekursiv.
 * Gibt alle Schritte der Lösung aus und misst die benötigte Zeit.
 */
public class TowersOfHanoi {
    private static int steps;

    /**
     * Einstiegspunkt des Programms.
     * Startet die Lösung für 5 Scheiben und gibt die benötigte Zeit und Schrittanzahl aus.
     *
     * @param args Programmargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        int numberOfDisks = 5;
        steps = 0;

        long startTime = System.currentTimeMillis();
        solveHanoi(numberOfDisks, 'A', 'C');
        long endTime = System.currentTimeMillis();

        System.out.println("Gelöst in " + (endTime - startTime) + " ms mit " + steps + " Schritten");
    }

    /**
     * Löst das Türme-von-Hanoi-Problem rekursiv.
     *
     * @param n Anzahl der Scheiben, die verschoben werden sollen.
     * @param from Ursprungsstab (z.B. 'A').
     * @param to Zielstab (z.B. 'C').
     */
    public static void solveHanoi(int n, char from, char to){
        char helper = getHelperRod(from, to);

        if (n==1) {
            System.out.println(from + " -> " + to);
            steps++;
        } else {
            solveHanoi(n - 1, from, helper);
            solveHanoi(1, from, to);
            solveHanoi(n - 1, helper, to);
        }
    }

    /**
     * Ermittelt den dritten Stab, der nicht als Start- oder Zielstab verwendet wird.
     *
     * @param from Startstab.
     * @param to Zielstab.
     * @return Hilfsstab ('A', 'B' oder 'C').
     */
    private static char getHelperRod(char from, char to) {
        if (from != 'A' && to != 'A') return 'A';
        if (from != 'B' && to != 'B') return 'B';
        return 'C';
    }
}
