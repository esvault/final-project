package org.example.algorithms;

//TODO Implement class
public class InsertionSort <T extends Comparable<T>> implements SortingStrategy<T> {
    @Override
    public void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = current;
        }
    }
}
