package main.java.sorting;

import java.util.Arrays;
import java.util.Random;

import static main.java.sorting.BubbleSort.*;
import static main.java.sorting.InsertionSort.*;
import static main.java.sorting.MergeSort.*;
import static main.java.sorting.SelectionSort.*;

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
     * Führt alle implementierten Sortieralgorithmen mit einem zufälligen Array aus
     * und gibt die sortierten Ergebnisse in der Konsole aus.
     *
     * @param args Programmargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        int[] randomArray = randomArray(10);
        System.out.println("Unsortiert: " + Arrays.toString(randomArray));

        System.out.println("SelectionSort: " + Arrays.toString(selectionSort(randomArray.clone())));
        System.out.println("SelectionSort Desc: " + Arrays.toString(selectionSortDesc(randomArray.clone())));

        System.out.println("BubbleSort: " + Arrays.toString(bubbleSort(randomArray.clone())));
        System.out.println("BubbleSort Desc: " + Arrays.toString(bubbleSortDesc(randomArray.clone())));

        System.out.println("InsertionSort: " + Arrays.toString(insertionSort(randomArray.clone())));
        System.out.println("InsertionSort Desc: " + Arrays.toString(insertionSortDesc(randomArray.clone())));
        System.out.println("InsertionSortShift: " + Arrays.toString(insertionSortShift(randomArray.clone())));
        System.out.println("InsertionSortShift Desc: " + Arrays.toString(insertionSortShiftDesc(randomArray.clone())));

        System.out.println("QuickSort: " + Arrays.toString(QuickSort.quickSort(randomArray.clone())));
        System.out.println("QuickSort Desc: " + Arrays.toString(QuickSort.quickSortDesc(randomArray.clone())));
        System.out.println("QuickSortRandom: " + Arrays.toString(QuickSortRandom.quickSort(randomArray.clone())));
        System.out.println("QuickSortRandom Desc: " + Arrays.toString(QuickSortRandom.quickSortDesc(randomArray.clone())));

        System.out.println("MergeSort: " + Arrays.toString(mergeSort(randomArray.clone())));
        System.out.println("MergeSort Desc: " + Arrays.toString(mergeSortDesc(randomArray.clone())));
    }

    /**
     * Erstellt ein neues Array der angegebenen Länge mit zufällig generierten
     * Ganzzahlen im Bereich von 1 bis 99 (inklusive).
     *
     * @param length die Länge des zu erstellenden Arrays
     * @return ein Array mit {@code length} vielen zufälligen Ganzzahlen zwischen 1 und 99
     */
    public static int[] randomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(99) + 1;
        }
        return array;
    }
}