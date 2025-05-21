package main.java.sorting;

/**
 * Implementiert den InsertionSort Algorithmus.
 *
 */
public class InsertionSort {
    /**
     * Sortiert ein Array mit dem Insertion-Sort-Algorithmus.
     * Elemente werden nacheinander aufgenommen und an der richtigen Stelle im bereits sortierten Teil eingefügt.
     *
     * @param array Das zu sortierende Array.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pointer = i;

            while (pointer > 0 && (array[pointer] < array[pointer - 1])) {
                int temp = array[pointer];
                array[pointer] = array[pointer - 1];
                array[pointer - 1] = temp;
                pointer--;
            }
        }

        return array;
    }

    /**
     * Sortiert ein Array mit dem Insertion-Sort-Algorithmus.
     * Elemente werden nacheinander aufgenommen und an der richtigen Stelle im bereits sortierten Teil eingefügt.
     *
     * @param array Das zu sortierende Array.
     * @return Das absteigend sortierte Array.
     */
    public static int[] insertionSortDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pointer = i;

            while (pointer > 0 && (array[pointer] > array[pointer - 1])) {
                int temp = array[pointer];
                array[pointer] = array[pointer - 1];
                array[pointer - 1] = temp;
                pointer--;
            }
        }

        return array;
    }

    /**
     * Sortiert ein Array mit dem Insertion-Sort-Algorithmus.
     * Elemente werden nacheinander aufgenommen und an die richtigen Stelle im bereits sortierten Teil geschoben.
     *
     * @param array Das zu sortierende Array.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] insertionSortShift(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int pointer = i - 1;

            while (pointer >= 0 && (current < array[pointer])) {
                array[pointer + 1] = array[pointer];
                pointer--;
            }

            array[pointer + 1] = current;
        }

        return array;
    }

    /**
     * Sortiert ein Array mit dem Insertion-Sort-Algorithmus.
     * Elemente werden nacheinander aufgenommen und an die richtigen Stelle im bereits sortierten Teil geschoben.
     *
     * @param array Das zu sortierende Array.
     * @return Das absteigend sortierte Array.
     */
    public static int[] insertionSortShiftDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int pointer = i - 1;

            while (pointer >= 0 && (current > array[pointer])) {
                array[pointer + 1] = array[pointer];
                pointer--;
            }

            array[pointer + 1] = current;
        }

        return array;
    }
}
