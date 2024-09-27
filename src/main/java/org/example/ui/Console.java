package org.example.ui;

import org.example.algorithms.BinarySearch;
import org.example.algorithms.CustomInsertionSort;
import org.example.algorithms.InsertionSort;
import org.example.algorithms.SortingStrategy;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.entity.SupportedTypes;
import org.example.buildEntity.UserObjectFactory;
import org.example.model.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Console {
    private ConsoleState state = ConsoleState.NO_ARRAY;
    private SupportedTypes[] currentArray;


    public void runMainLoop() {

        mainLoop:
        while (true) {
            switch (state) {
                case NO_ARRAY -> fillArray();
                case ARRAY_INITIALIZED, ARRAY_SORTED -> askAction();

                case EXIT -> {
                    break mainLoop;
                }
            }
        }
    }

    private void fillArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите способ заполнения массива (1 - случайно, 2 - из файла, 3 - пользовательский)");

        int userResponse;
        try {
            userResponse = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите число");
            fillArray();
            return;
        }

        FillStrategy fillStrategy;
        switch (userResponse) {
            case 1 -> fillStrategy = new RandomFillStrategy();
            case 2 -> fillStrategy = new FileFillStrategy();
            case 3 -> fillStrategy = new UserFillStrategy();
            default -> {
                System.out.println("Нет такой команды");
                fillArray();
                return;
            }
        };

        System.out.println("Введите тип элементов (1 - Animal, 2 - Barrel, 3 - Human)");
        int elementTypeCode;
        try {
            elementTypeCode = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите число");
            fillArray();
            return;
        }

        switch (elementTypeCode) {
            case 1: currentArray = fillStrategy.fillArrayByAnimals(); break;
            case 2: currentArray = fillStrategy.fillArrayByBarrels(); break;
            case 3: currentArray = fillStrategy.fillArrayByHumans(); break;

//            default: throw new IllegalArgumentException("Несуществующий вариант ответа");
            default: {
                System.out.println("Нет такой команды");
                fillArray();
                return;
            }
        }

        System.out.println("Ваш массив: " + Arrays.toString(currentArray));
        state = ConsoleState.ARRAY_INITIALIZED;
    }

    private void askAction() {
        System.out.println("Выберите действие, которое хотите исполнить (1 - отсортировать, 2 - отсортировать " +
                "\"по-особенному\", 3 - выполнить бинарный поиск, 4 - создать новый массив, 5 - выйти)");
        Scanner sc = new Scanner(System.in);

        int askResponse;
        try {
            askResponse = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите число");
            fillArray();
            return;
        }

        switch (askResponse) {
            case 1: {
                if (state == ConsoleState.NO_ARRAY) {
                    System.out.println("Array must be filled");
                    return;
                }

                SortingStrategy<SupportedTypes> ss = new InsertionSort<>();
                ss.sort(currentArray);

                state = ConsoleState.ARRAY_SORTED;
                System.out.println("Отсортированный массив: " + Arrays.toString(currentArray));
                break;
            }
            case 2: {
                if (state == ConsoleState.NO_ARRAY) {
                    System.out.println("Array must be filled");
                    return;
                }

                SortingStrategy ss = new CustomInsertionSort<>(currentArray[0].getClass());
                ss.sort(currentArray);

                state = ConsoleState.ARRAY_SORTED;
                System.out.println("Отсортированный массив: " + Arrays.toString(currentArray));
                break;
            }
            case 3: {
                if (state != ConsoleState.ARRAY_SORTED) {
                    System.out.println("Прежде чем выполнить бинарный поиск, отсортируйте массив");
                    return;
                }
                System.out.println("Введите данные для поиска");
                SupportedTypes elem = askDataForBinSearch();
                int binSearchResult = BinarySearch.search(currentArray, elem);
                if (binSearchResult == -1) {
                    System.out.println("Элемент не найден");
                    break;
                }
                System.out.println("Индекс искомого элемента: " + binSearchResult);
                break;
            }
            case 4: {
                fillArray();
                break;
            }
            case 5: {
                state = ConsoleState.EXIT;
            }
            default:
                System.out.println("Нет такой команды");
        }

    }

    private SupportedTypes askDataForBinSearch() {
        SupportedTypes searchedElement;
        UserObjectFactory factory = new UserObjectFactory();

        if (currentArray[0] instanceof Animal)
            searchedElement = factory.createAnimal();

        else if (currentArray[0] instanceof Barrel)
            searchedElement = factory.createBarrel();

        else if (currentArray[0] instanceof Human)
            searchedElement = factory.createHuman();

        else
            searchedElement = null;

        return searchedElement;
    }

    public enum ConsoleState {
        NO_ARRAY,
        ARRAY_INITIALIZED,
        ARRAY_SORTED,
        EXIT
    }
}
