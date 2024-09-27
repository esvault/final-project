package org.example.algorithms;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CustomInsertionSort<T> implements SortingStrategy<T> {
    private Field intField;

    public CustomInsertionSort(Class<T> clazz) throws IllegalArgumentException {
        this.intField = findIntegerField(clazz);
        if (this.intField == null) {
            throw new IllegalArgumentException("Class " + clazz.getName() + " doesn't contain an int or Integer type field.");
        }
    }

    private Field findIntegerField(Class<T> clazz) {

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType() == Integer.class || field.getType() == int.class) {
                field.setAccessible(true);
                return field;
            }
        }
        return null;
    }

    @Override
    public void sort(T[] array) {
        List<T> objectWithEvenValues = new ArrayList<>();
        int evenCount = 0;

        // Сбор пар объектов и их индексов, где значение поля четное
        for (int i = 0; i < array.length; i++) {
            T currentObject = array[i];
            // Получаем значение поля для текущего объекта
            Integer currentValue = getFieldValue(currentObject);
            if (currentValue % 2 == 0) {
                objectWithEvenValues.add(currentObject);
                evenCount++;
            }
        }

        if (objectWithEvenValues.size() < 2) {
            return;
        }

        // Сортировка четных значений с использованием сортировки вставками
        for (int i = 1; i < evenCount; i++) {
            T currentObject = objectWithEvenValues.get(i);
            int j = i - 1;

            while (j >= 0 && getFieldValue(objectWithEvenValues.get(j)) > getFieldValue(currentObject)) {
                objectWithEvenValues.set(j + 1, objectWithEvenValues.get(j));
                j = j - 1;
            }
            objectWithEvenValues.set(j + 1, currentObject);
        }

        evenCount = 0;
        // Вставка отсортированных четных значений обратно в исходный массив
        for (int i = 0; i < array.length; i++) {
            if (getFieldValue(array[i]) % 2 == 0) {
                array[i] = objectWithEvenValues.get(evenCount++);
            }
        }
    }

    private Integer getFieldValue(T object) {
        try {
            return (Integer) intField.get(object);
        } catch (IllegalAccessException e) {
            return null;
        }
    }
}
