package main.java.sorting;

/**
 * Implementiert den QuickSort Algorithmus.
 *
 */
public class QuickSort {
    /**
     * Führt die Partitionierung für QuickSort durch.
     * Wählt das letzte Element als Pivot und ordnet alle kleineren Elemente nach links.
     *
     * @param array Das zu partitionierende Array.
     * @param begin Der Startindex des Bereichs.
     * @param end Der Endindex des Bereichs (Pivot wird hier gewählt).
     * @return Die neue Position des Pivot-Elements nach der Partitionierung.
     */
    private static int partition(int[] array, int begin, int end) {
        int pos = begin;
        int pivot = end;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[pos];
                array[pos] = array[i];
                array[i] = temp;
                pos++;
            }
        }
        int temp = array[pos];
        array[pos] = array[end];
        array[end] = temp;
        pivot = pos;
        return pivot;
    }

    /**
     * Sortiert ein Array mit dem Quick-Sort-Algorithmus.
     * Ein Pivot-Element wird gewählt, das Array wird in kleinere und größere Teile geteilt
     * und die Teilarrays werden rekursiv sortiert.
     *
     * @param array Das zu sortierende Array.
     * @param begin Startindex des zu sortierenden Bereichs.
     * @param end Endindex des zu sortierenden Bereichs.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return array;
        } else {
            int pivot_pos = partition(array, begin, end);
            array = quickSort(array, begin, pivot_pos - 1);
            array = quickSort(array, pivot_pos + 1, end);
        }
        return array;
    }

    /**
     * Sortiert ein Array mit dem Quick-Sort-Algorithmus.
     * Ein Pivot-Element wird gewählt, das Array wird in kleinere und größere Teile geteilt
     * und die Teilarrays werden rekursiv sortiert.
     *
     * @param array Das zu sortierende Array.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    /**
     * Führt die Partitionierung für QuickSort durch.
     * Wählt das letzte Element als Pivot und ordnet alle größeren Elemente nach links.
     *
     * @param array Das zu partitionierende Array.
     * @param begin Der Startindex des Bereichs.
     * @param end Der Endindex des Bereichs (Pivot wird hier gewählt).
     * @return Die neue Position des Pivot-Elements nach der Partitionierung.
     */
    private static int partitionDesc(int[] array, int begin, int end) {
        int pos = begin;
        int pivot = end;
        for (int i = begin; i < end; i++) {
            if (array[i] > array[pivot]) {
                int temp = array[pos];
                array[pos] = array[i];
                array[i] = temp;
                pos++;
            }
        }
        int temp = array[pos];
        array[pos] = array[end];
        array[end] = temp;
        pivot = pos;
        return pivot;
    }

    /**
     * Sortiert ein Array mit dem Quick-Sort-Algorithmus.
     * Ein Pivot-Element wird gewählt, das Array wird in kleinere und größere Teile geteilt
     * und die Teilarrays werden rekursiv sortiert.
     *
     * @param array Das zu sortierende Array.
     * @param begin Startindex des zu sortierenden Bereichs.
     * @param end Endindex des zu sortierenden Bereichs.
     * @return Das absteigend sortierte Array.
     */
    public static int[] quickSortDesc(int[] array, int begin, int end) {
        if (begin >= end) {
            return array;
        } else {
            int pivot_pos = partitionDesc(array, begin, end);
            array = quickSortDesc(array, begin, pivot_pos - 1);
            array = quickSortDesc(array, pivot_pos + 1, end);
        }
        return array;
    }

    /**
     * Sortiert ein Array mit dem Quick-Sort-Algorithmus.
     * Ein Pivot-Element wird gewählt, das Array wird in kleinere und größere Teile geteilt
     * und die Teilarrays werden rekursiv sortiert.
     *
     * @param array Das zu sortierende Array.
     * @return Das absteigend sortierte Array.
     */
    public static int[] quickSortDesc(int[] array) {
        return quickSortDesc(array, 0, array.length - 1);
    }
}
