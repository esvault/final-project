package org.example.ui;

import org.example.algorithms.BinarySearch;
import org.example.algorithms.InsertionSort;
import org.example.algorithms.SortingStrategy;
import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.entity.SupportedTypes;
import org.example.enums.ConsoleState;
import org.example.enums.ReturnCode;
import org.example.model.*;
import org.example.factory.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import static org.example.model.UserFillStrategy.*;

public class Console {
    private ConsoleState state = ConsoleState.NO_ARRAY;
    private SupportedTypes[] currentArray;
    private FillStrategy fillStrategy;


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

    private ReturnCode fillArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите способ заполнения массива (1 - случайно, 2 - из файла, 3 - пользовательский)");

        Integer userResponse = sc.nextInt();
        validateFillArrayInput(userResponse);

        switch (userResponse) {
            case 1: fillStrategy = new RandomFillStrategy(); break;
            case 2:
                boolean isNotFound = true;
                String filePath = null;
                File file = null;
                while (isNotFound){
                    System.out.println("Введите путь к файлу");
                    filePath = sc.next();
                    file = new File(filePath);
                    if(!file.exists()){
                        System.out.println("Such file not found please try again");
                        continue;
                    }
                    isNotFound = false;
                }
                fillStrategy = new FileFillStrategy(file);
                break;
            case 3: fillStrategy = new UserFillStrategy(); break;

            default: throw new IllegalArgumentException("Несуществующая команда");
        }

        System.out.println("Введите тип элементов (1 - Animal, 2 - Barrel, 3 - Human)");
        int elementTypeCode = sc.nextInt();

        switch (elementTypeCode) {
            case 1: currentArray = fillStrategy.fillArrayByAnimals(); break;
            case 2: currentArray = fillStrategy.fillArrayByBarrels(); break;
            case 3: currentArray = fillStrategy.fillArrayByHumans(); break;

            default: throw new IllegalArgumentException("Несуществующий вариант ответа");
        }

        System.out.println("Ваш массив: " + Arrays.toString(currentArray));
        state = ConsoleState.ARRAY_INITIALIZED;
        return ReturnCode.OK;
    }

    private ReturnCode askAction() {
        System.out.println("Выберите действие, которое хотите исполнить (1 - отсортировать, 2 - выполнить бинарный поиск, 3 - создать новый массив, 4 - выйти)");
//        System.out.println("Choose action to be executed (1 - sort, 2 - binary search, 3 - new array, 4 - exit)");
        Scanner sc = new Scanner(System.in);
        int askResponse = sc.nextInt();

        switch (askResponse) {
            case 1: {
                if (state == ConsoleState.NO_ARRAY) {
                    System.out.println("Array must be filled");
                    return ReturnCode.ERROR;
                }

                SortingStrategy<SupportedTypes> ss = new InsertionSort<>();
                ss.sort(currentArray);

                state = ConsoleState.ARRAY_SORTED;
                System.out.println("Your sorted array: " + Arrays.toString(currentArray));
                break;
            }
            case 2: {
                if (state != ConsoleState.ARRAY_SORTED) {
                    System.out.println("Прежде чем выполнить бинарный поиск, отсортируйте массив");
                    return ReturnCode.ERROR;
                }
                // выполнить бинарный поиск
                System.out.println("Введите данные для поиска");
                SupportedTypes elem = askDataForBinSearch();
                int binSearchResult = BinarySearch.search(currentArray, elem);
                System.out.println("Индекс искомого элемента: " + binSearchResult);
                break;
            }
            case 3: {
                ReturnCode fillingReturnCode = fillArray();
                if (fillingReturnCode == ReturnCode.OK)
                    state = ConsoleState.ARRAY_INITIALIZED;
                return fillingReturnCode;
            }
            case 4: {
                state = ConsoleState.EXIT;
                return ReturnCode.OK;
            }
        }

        return ReturnCode.OK;
    }

    private SupportedTypes askDataForBinSearch() {
        ObjectFactory factory = new UserObjectFactory();
        SupportedTypes searchedElement;
        System.out.println("Введите данные по объекту, который хотите найти");
        if (currentArray[0] instanceof Animal) {
            searchedElement = factory.createAnimal();
        } else if (currentArray[0] instanceof Barrel) {
            searchedElement = factory.createBarrel();
        } else if (currentArray[0] instanceof Human) {
            searchedElement = factory.createHuman();
        } else {
            searchedElement = null;
        }

        return searchedElement;
    }

    private void validateFillArrayInput(Integer response) {
    }
}
