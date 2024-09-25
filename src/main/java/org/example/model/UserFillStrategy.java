package org.example.model;

import org.example.director.Director;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.buildEntity.*;
import org.example.utils.Validator;

import java.util.Scanner;

//TODO Implement class
public class UserFillStrategy implements FillStrategy {
    private int arrayLen;
    private Scanner scanner;
    private Director director;

    {
        scanner = new Scanner(System.in);
        director = new Director();

        System.out.println("Enter length of array");
        arrayLen = scanner.nextInt();
    }

    @Override
    public Animal[] fillArrayByAnimals() {
        Animal[] animals = new Animal[arrayLen];

        for (int i = 0; i < arrayLen; i++) {
            String species = validateStringInput("Введите вид животного: ");
            String eyeColor = validateStringInput("Введите цвет глаз: ");
            boolean wool = validateBooleanInput("Есть ли шерсть? (да/нет): ");

            animals[i] = director.createAnimal(species, eyeColor, wool);
        }

        return animals;
    }

    @Override
    public Barrel[] fillArrayByBarrels() {
        Barrel[] barrels = new Barrel[arrayLen];

        for (int i = 0; i < arrayLen; i++) {
            int volume = validateIntInput("Введите объем бочки (в литрах): ");
            String content = validateStringInput("Введите хранимый материал: ");
            String material = validateStringInput("Введите материал, из которого изготовлена бочка: ");

            barrels[i] = director.createBarrel(volume, content, material);
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans() {
        Human[] persons = new Human[arrayLen];

        for (int i = 0; i < arrayLen; i++) {
            String gender = validateStringInput("Введите пол: ");
            int age = validateIntInput("Введите возраст: ");
            String surname = validateStringInput("Введите фамилию: ");

            persons[i] = director.createHuman(gender, age, surname);
        }
        return persons;
    }

    private String validateStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (Validator.containsOnlyLetters(input)) {
            System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            input = scanner.nextLine();
        }
        return input;
    }

    private int validateIntInput(String prompt) {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 0) {
                    throw new NumberFormatException();
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.print("Некорректный ввод. Введите положительное число: ");
            }
        }
        return input;
    }

    private boolean validateBooleanInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().toLowerCase();
        while (Validator.validateBoolean(input)) {
            System.out.print("Некорректный ввод. Введите 'yes'/'no': ");
            input = scanner.nextLine().toLowerCase();
        }
        return input.equals("yes");
    }
}
