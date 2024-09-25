package org.example.algorithms;

import java.util.Comparator;

public class InsertionSortWithComparator <T extends Comparable<T>> extends InsertionSort<T>{
    public void sort(T[] array, Comparator<? super T> comparator) {
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(array[j], current) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = current;
        }
    }
}
