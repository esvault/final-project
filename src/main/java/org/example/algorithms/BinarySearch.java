package org.example.algorithms;

//TODO Implement class
public class BinarySearch {
    public static <T extends Comparable<T>> int search(T[] array, T key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Здесь можно сделать проверку через equals()
            if (array[mid].compareTo(key) == 0) {
                return mid;
            }
            if (array[mid].compareTo(key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
