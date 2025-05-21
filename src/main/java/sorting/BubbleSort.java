package main.java.sorting;

/**
 * Implementiert den BubbleSort Algorithmus.
 *
 */
public class BubbleSort {
    /**
     * Sortiert ein Array mit dem Bubble-Sort-Algorithmus.
     * Wiederholt werden benachbarte Elemente vertauscht, wenn sie in falscher Reihenfolge sind.
     * Die größten Elemente „wandern“ dabei nach oben.
     *
     * @param array Das zu sortierende Array.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return array;
    }

    /**
     * Sortiert ein Array mit dem Bubble-Sort-Algorithmus.
     * Wiederholt werden benachbarte Elemente vertauscht, wenn sie in falscher Reihenfolge sind.
     * Die größten Elemente „wandern“ dabei nach oben.
     *
     * @param array Das zu sortierende Array.
     * @return Das absteigend sortierte Array.
     */
    public static int[] bubbleSortDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return array;
    }
}
