package main.java.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Die {@code Main}-Klasse dient als Einstiegspunkt für das Programm und demonstriert
 * die Funktionsweise verschiedener Sortieralgorithmen.
 *
 * <p>Für ein zufällig generiertes Integer-Array werden die Sortieralgorithmen
 * SelectionSort, BubbleSort, InsertionSort, MergeSort, QuickSort und QuickSort mit
 * Zufallspivot jeweils in aufsteigender und absteigender Reihenfolge ausgeführt.
 */
public class Main {
    /**
     * Einstiegspunkt des Programms.
     * Führt alle implementierten Sortieralgorithmen auf einem zufälligen Array aus
     * und gibt die sortierten Ergebnisse in der Konsole aus.
     *
     * @param args Programmargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        boolean showArrays = true; // Zeige die Arrays in der Ausgabe.
        boolean measureTime = true; // Erfasse die Laufzeit (in ms).

        // Generieren ein zufälliges Array
        int[] randomArray = randomArray(10_000);
        if (showArrays) System.out.println("Unsortiert: " + arrayStringPreview(randomArray, 10));

        // ---------- SelectionSort ----------
        sortAndPrint("SelectionSort", randomArray, showArrays, measureTime, SelectionSort::selectionSort, SelectionSort::selectionSortDesc);

        // ---------- BubbleSort ----------
        sortAndPrint("BubbleSort", randomArray, showArrays, measureTime, BubbleSort::bubbleSort, BubbleSort::bubbleSortDesc);

        // ---------- InsertionSort ----------
        sortAndPrint("InsertionSort", randomArray, showArrays, measureTime, InsertionSort::insertionSort, InsertionSort::insertionSortDesc);
        sortAndPrint("InsertionSortShift", randomArray, showArrays, measureTime, InsertionSort::insertionSortShift, InsertionSort::insertionSortShiftDesc);

        // ---------- QuickSort ----------
        sortAndPrint("QuickSort", randomArray, showArrays, measureTime, QuickSort::quickSort, QuickSort::quickSortDesc);
        sortAndPrint("QuickSortRandom", randomArray, showArrays, measureTime, QuickSortRandom::quickSort, QuickSortRandom::quickSortDesc);

        // ---------- MergeSort ----------
        sortAndPrint("MergeSort", randomArray, showArrays, measureTime, MergeSort::mergeSort, MergeSort::mergeSortDesc);
        sortAndPrint("MergeSortOptimized", randomArray, showArrays, measureTime, MergeSortOptimized::mergeSort, MergeSortOptimized::mergeSortDesc);
    }

    /**
     * Erstellt ein neues Array der angegebenen Länge mit zufällig generierten
     * Ganzzahlen im Bereich von 1 bis 999999 (inklusive).
     *
     * @param length die Länge des zu erstellenden Arrays
     * @return ein Array mit {@code length} vielen zufälligen Ganzzahlen zwischen 1 und 999999
     */
    public static int[] randomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(999_999) + 1;
        }
        return array;
    }

    @FunctionalInterface
    interface SortFunction {
        int[] sort(int[] array);
    }

    /**
     * Führt die gegebenen Sortieralgorithmen mit den gegebenen Parametern aus und
     * gibt das Ergebnis in der Konsole aus.
     *
     * @param name Der Name des Algorithmus.
     * @param original Das zu sortierende Array.
     * @param showArrays Ob die Arrays in der Ausgabe angezeigt werden sollen.
     * @param measureTime Ob die Laufzeit erfasst werden soll.
     * @param ascSorter Die Funktion für die aufsteigende Sortierung.
     * @param descSorter Die Funktion für die absteigende Sortierung.
     */
    private static void sortAndPrint(String name, int[] original, boolean showArrays,
                                     boolean measureTime, SortFunction ascSorter, SortFunction descSorter) {
        long start = 0, end;
        int[] result;

        // Aufsteigende Sortierung
        if (measureTime) start = System.currentTimeMillis();
        result = ascSorter.sort(original.clone());
        if (measureTime) {
            end = System.currentTimeMillis();
            System.out.printf("%s (%dms): %s%n", name, (end - start), showArrays ? arrayStringPreview(result, 10) : "");
        } else {
            System.out.printf("%s: %s%n", name, showArrays ? Arrays.toString(result) : "");
        }

        // Absteigende Sortierung
        if (measureTime) start = System.currentTimeMillis();
        result = descSorter.sort(original.clone());
        if (measureTime) {
            end = System.currentTimeMillis();
            System.out.printf("%s Desc (%dms): %s%n", name, (end - start), showArrays ? arrayStringPreview(result, 10) : "");
        } else {
            System.out.printf("%s Desc: %s%n", name, showArrays ? Arrays.toString(result) : "");
        }
    }

    /**
     * Gibt eine Vorschau des Arrays zurück:
     * Wenn das Array kürzer als {@code max * 2} ist, wird es vollständig angezeigt.
     * Andernfalls werden nur die ersten {@code max} und letzten {@code max} Elemente ausgegeben,
     * getrennt durch eine Auslassung ("...").
     *
     * @param array Das darzustellende Array.
     * @param max Die Anzahl der anzuzeigenden Elemente am Anfang und Ende.
     * @return Eine formatierte Zeichenkette mit einer Vorschau des Arrays.
     */
    private static String arrayStringPreview(int[] array, int max) {
        if (array.length < max*2) return Arrays.toString(array);
        return Arrays.toString(Arrays.copyOfRange(array, 0, max)) + " ... " +
                Arrays.toString(Arrays.copyOfRange(array, array.length - max, array.length));
    }
}