package main.java.sorting;

/**
 * Implementiert den SelectionSort Algorithmus.
 *
 */
public class SelectionSort {
    /**
     * Sortiert ein Array mit dem Selection-Sort-Algorithmus.
     * Es wird wiederholt das kleinste Element im unsortierten Teil gesucht
     * und mit dem ersten unsortierten Element getauscht.
     *
     * @param array Das zu sortierende Array.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) { // i = anfang
            int minIndex = i;

            for (int j = minIndex + 1; j < array.length; j++) { // j = zeiger
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }

    /**
     * Sortiert ein Array mit dem Selection-Sort-Algorithmus.
     * Es wird wiederholt das größte Element im unsortierten Teil gesucht
     * und mit dem ersten unsortierten Element getauscht.
     *
     * @param array Das zu sortierende Array.
     * @return Das absteigend sortierte Array.
     */
    public static int[] selectionSortDesc(int[] array) {
        for (int i = 0; i < array.length; i++) { // i = anfang
            int minIndex = i;

            for (int j = minIndex + 1; j < array.length; j++) { // j = zeiger
                if (array[j] > array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }
}
