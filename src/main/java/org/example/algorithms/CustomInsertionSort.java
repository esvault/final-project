package org.example.algorithms;

import java.lang.reflect.Field;
import java.util.AbstractMap.SimpleEntry;
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
        // Ищем все поля в классе на наличие поля типа int (или Integer)
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
        List<SimpleEntry<T, Integer>> evenValues = new ArrayList<>();
        int evenCount = 0;

        // Сбор пар объектов и их индексов, где значение поля четное
        for (int i = 0; i < array.length; i++) {
            T current = array[i];
            // Получаем значение поля для текущего объекта
            Integer currentValue = getFieldValue(current);
            if (currentValue % 2 == 0) {
                evenValues.add(new SimpleEntry<>(current, i));
                evenCount++;
            }
        }

        // Сортировка четных значений с использованием сортировки вставками
        for (int i = 1; i < evenCount; i++) {
            Integer currentIndex = evenValues.get(i).getValue();
            Integer current = getFieldValue(evenValues.get(i).getKey());
            int j = i - 1;

            while (j >= 0 && getFieldValue(evenValues.get(j).getKey()) > current) {
                evenValues.get(j + 1).setValue(evenValues.get(j).getValue());
                j--;
            }
            evenValues.get(j + 1).setValue(currentIndex);
        }

        // Вставка отсортированных четных значений обратно в исходный массив
        for (SimpleEntry<T, Integer> pair : evenValues) {
            array[pair.getValue()] = pair.getKey();
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
