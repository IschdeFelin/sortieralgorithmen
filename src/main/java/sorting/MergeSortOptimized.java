package main.java.sorting;

public class MergeSortOptimized {
    /**
     * Gibt die linke Hälfte eines Arrays bis zum gegebenen Index zurück.
     *
     * @param array Das Ursprungsarray.
     * @param middle Der Index, bis zu dem das Array aufgeteilt werden soll (exklusiv).
     * @return Ein neues Array mit den Elementen der linken Hälfte.
     */
    private static int[] leftHalf(int[] array, int middle) {
        int[] leftArray = new int[middle];
        System.arraycopy(array, 0, leftArray, 0, middle);
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
        System.arraycopy(array, middle, rightArray, 0, rightArray.length);
        return rightArray;
    }

    /**
     * Führt zwei sortierte Arrays zu einem neuen, sortierten Array in aufsteigender Reihenfolge zusammen.
     * Dabei wird anders als bei der normalen {@code merge()} Methode kein Hilfsarray erstellt.
     *
     * @param left Das sortierte linke Teilarray.
     * @param right Das sortierte rechte Teilarray.
     */
    private static void merge(int[] array, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize =  right.length;

        int l = 0, r = 0, pos = 0;
        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                array[pos] = left[l];
                l++;
            } else {
                array[pos] = right[r];
                r++;
            }
            pos++;
        }

        while (l < leftSize) {
            array[pos] = left[l];
            l++;
            pos++;
        }
        while (r < rightSize) {
            array[pos] = right[r];
            r++;
            pos++;
        }
    }

    /**
     * Sortiert ein Array mit dem Merge-Sort-Algorithmus (Teile-und-Herrsche-Prinzip).
     * Das Array wird rekursiv in Hälften geteilt und anschließend sortiert zusammengeführt.
     * Dabei wird beim merge Prozess anders als bei der normalen {@code merge()} Methode kein Hilfsarray erstellt.
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
            mergeSort(leftHalf);
            mergeSort(rightHalf);
            merge(array, leftHalf, rightHalf);
            return array;
        }
    }

    /**
     * Führt zwei sortierte Arrays zu einem neuen, sortierten Array in aufsteigender Reihenfolge zusammen.
     * Dabei wird anders als bei der normalen {@code merge()} Methode kein Hilfsarray erstellt.
     *
     * @param left Das sortierte linke Teilarray.
     * @param right Das sortierte rechte Teilarray.
     */
    private static void mergeDesc(int[] array, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize =  right.length;

        int l = 0, r = 0, pos = 0;
        while (l < leftSize && r < rightSize) {
            if (left[l] > right[r]) {
                array[pos] = left[l];
                l++;
            } else {
                array[pos] = right[r];
                r++;
            }
            pos++;
        }

        while (l < leftSize) {
            array[pos] = left[l];
            l++;
            pos++;
        }
        while (r < rightSize) {
            array[pos] = right[r];
            r++;
            pos++;
        }
    }

    /**
     * Sortiert ein Array mit dem Merge-Sort-Algorithmus (Teile-und-Herrsche-Prinzip).
     * Das Array wird rekursiv in Hälften geteilt und anschließend sortiert zusammengeführt.
     * Dabei wird beim merge Prozess anders als bei der normalen {@code merge()} Methode kein Hilfsarray erstellt.
     *
     * @param array Das zu sortierende Array.
     * @return Das aufsteigend sortierte Array.
     */
    public static int[] mergeSortDesc(int[] array) {
        if (array.length <= 1) {
            return array;
        } else {
            int middle = array.length/2;
            int[] leftHalf = leftHalf(array, middle);
            int[] rightHalf = rightHalf(array, middle);
            mergeSortDesc(leftHalf);
            mergeSortDesc(rightHalf);
            mergeDesc(array, leftHalf, rightHalf);
            return array;
        }
    }
}
