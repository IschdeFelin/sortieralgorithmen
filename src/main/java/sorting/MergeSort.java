package main.java.sorting;

/**
 * Implementiert den MergeSort Algorithmus.
 *
 */
public class MergeSort {
    /**
     * Gibt die linke Hälfte eines Arrays bis zum gegebenen Index zurück.
     *
     * @param array Das Ursprungsarray.
     * @param middle Der Index, bis zu dem das Array aufgeteilt werden soll (exklusiv).
     * @return Ein neues Array mit den Elementen der linken Hälfte.
     */
    private static int[] leftHalf(int[] array, int middle) {
        int[] leftArray = new int[middle];
        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        return leftArray;
    }

    /**
     * Gibt die rechte Hälfte eines Arrays ab dem gegebenen Index zurück.
     *
     * @param array Das Ursprungsarray.
     * @param middle Der Index, ab dem die rechte Hälfte beginnt.
     * @return Ein neues Array mit den Elementen der rechten Hälfte.
     */
    private static int[] rightHalf(int[] array, int middle) {
        int[] rightArray = new int[array.length - middle];
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[middle + i];
        }
        return rightArray;
    }

    /**
     * Führt zwei sortierte Arrays zu einem neuen, sortierten Array in aufsteigender Reihenfolge zusammen.
     *
     * @param left Das sortierte linke Teilarray.
     * @param right Das sortierte rechte Teilarray.
     * @return Ein neues Array mit den zusammengeführten und sortierten Elementen.
     */
    private static int[] merge(int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize =  right.length;

        int l = 0, r = 0, pos = 0;
        int[] mergedArray = new int[leftSize + rightSize];
        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                mergedArray[pos] = left[l];
                l++;
            } else {
                mergedArray[pos] = right[r];
                r++;
            }
            pos++;
        }

        while (l < leftSize) {
            mergedArray[pos] = left[l];
            l++;
            pos++;
        }
        while (r < rightSize) {
            mergedArray[pos] = right[r];
            r++;
            pos++;
        }

        return mergedArray;
    }

    /**
     * Sortiert ein Array mit dem Merge-Sort-Algorithmus (Teile-und-Herrsche-Prinzip).
     * Das Array wird rekursiv in Hälften geteilt und anschließend sortiert zusammengeführt.
     *
     * @param array Das zu sortierende Array.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        } else {
            int middle = array.length/2;
            int[] leftHalf = leftHalf(array, middle);
            int[] rightHalf = rightHalf(array, middle);
            leftHalf = mergeSort(leftHalf);
            rightHalf = mergeSort(rightHalf);
            array = merge(leftHalf, rightHalf);
            return array;
        }
    }

    /**
     * Führt zwei sortierte Arrays zu einem neuen, sortierten Array in absteigender Reihenfolge zusammen.
     *
     * @param left Das sortierte linke Teilarray.
     * @param right Das sortierte rechte Teilarray.
     * @return Ein neues Array mit den zusammengeführten und sortierten Elementen.
     */
    private static int[] mergeDesc(int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize =  right.length;

        int l = 0, r = 0, pos = 0;
        int[] mergedArray = new int[leftSize + rightSize];
        while (l < leftSize && r < rightSize) {
            if (left[l] > right[r]) {
                mergedArray[pos] = left[l];
                l++;
            } else {
                mergedArray[pos] = right[r];
                r++;
            }
            pos++;
        }

        while (l < leftSize) {
            mergedArray[pos] = left[l];
            l++;
            pos++;
        }
        while (r < rightSize) {
            mergedArray[pos] = right[r];
            r++;
            pos++;
        }

        return mergedArray;
    }

    /**
     * Sortiert ein Array mit dem Merge-Sort-Algorithmus (Teile-und-Herrsche-Prinzip).
     * Das Array wird rekursiv in Hälften geteilt und anschließend sortiert zusammengeführt.
     *
     * @param array Das zu sortierende Array.
     * @return Das absteigend sortierte Array.
     */
    public static int[] mergeSortDesc(int[] array) {
        if (array.length <= 1) {
            return array;
        } else {
            int middle = array.length/2;
            int[] leftHalf = leftHalf(array, middle);
            int[] rightHalf = rightHalf(array, middle);
            leftHalf = mergeSortDesc(leftHalf);
            rightHalf = mergeSortDesc(rightHalf);
            array = mergeDesc(leftHalf, rightHalf);
            return array;
        }
    }
}
