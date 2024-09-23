package org.example.ui;

import org.example.algorithms.InsertionSort;
import org.example.algorithms.SortingStrategy;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.entity.SupportedTypes;
import org.example.enums.ConsoleState;
import org.example.enums.ReturnCode;
import org.example.model.*;

import java.util.Arrays;
import java.util.Scanner;

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
        System.out.println("Enter array filling way (1 - random, 2 - from file, 3 - by user)");

        Integer userResponse = sc.nextInt();
        validateFillArrayInput(userResponse);

        switch (userResponse) {
            case 1: fillStrategy = new RandomFillStrategy(); break;
            case 2: fillStrategy = new FileFillStrategy("C:\\Users\\Lena\\Documents\\GitHub\\final-project\\src\\main\\resources\\animals.json",5); break;
            case 3: fillStrategy = new UserFillStrategy(); break;

            default: throw new IllegalArgumentException("Несуществующая команда");
        }

        System.out.println("Type of elements (1 - Animal, 2 - Barrel, 3 - Human)");
        int elementTypeCode = sc.nextInt();

        switch (elementTypeCode) {
            case 1: currentArray = fillStrategy.fillArrayByAnimals(); break;
//            case 2: currentArray = fillStrategy.fillArrayByBarrels(); break;
//            case 3: currentArray = fillStrategy.fillArrayByHumans(); break;

            default: throw new IllegalArgumentException("Несуществующий вариант ответа");
        }

        System.out.println("Your array: " + Arrays.toString(currentArray));
        state = ConsoleState.ARRAY_INITIALIZED;
        return ReturnCode.OK;
    }

    private ReturnCode askAction() {
        System.out.println("Choose action to be executed (1 - sort, 2 - binary search, 3 - new array, 4 - exit)");
        Scanner sc = new Scanner(System.in);
        int askResponse = sc.nextInt();

        switch (askResponse) {
            case 1: {
                if (state == ConsoleState.NO_ARRAY) {
                    System.out.println("Array must be filled");
                    return ReturnCode.ERROR;
                }

                if (currentArray[0] instanceof Animal) {
                    SortingStrategy<Animal> ss = new InsertionSort<>();
                    ss.sort((Animal[]) currentArray);
                } else if (currentArray[0] instanceof Barrel) {
                    SortingStrategy<Barrel> ss = new InsertionSort<>();
                    ss.sort((Barrel[]) currentArray);
                } else if (currentArray[0] instanceof Human) {
                    SortingStrategy<Human> ss = new InsertionSort<>();
                    ss.sort((Human[]) currentArray);
                } else {
                    System.out.println("Unsupported type");
                    return ReturnCode.ERROR;
                }

                state = ConsoleState.ARRAY_SORTED;
                break;
            }
            case 2: {
                if (state != ConsoleState.ARRAY_SORTED) {
                    System.out.println("Sort array before applying binary search");
                    return ReturnCode.ERROR;
                }
                // выполнить бинарный поиск
                System.out.println("Enter element to be search");
//                BinarySearch.search(currentArray, )
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

    private void validateFillArrayInput(Integer response) {
    }
}
