package org.example.model;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.buildEntity.*;

import java.util.Scanner;

//TODO Implement class
public class UserFillStrategy implements FillStrategy {
    private int arrayLen;
    private Scanner scanner;

    {
        System.out.println("Enter length of array");
        Scanner sc = new Scanner(System.in);
        arrayLen = sc.nextInt();
    }

    public UserFillStrategy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Animal[] fillArrayByAnimals() {
        Animal[] animals = new Animal[arrayLen];
        BuildAnimal builder = new BuildAnimal();

        for (int i = 0; i < arrayLen; i++) {
            builder.setSpecies(validateStringInput("Введите вид животного: "));
            builder.setEyeColor(validateStringInput("Введите цвет глаз: "));
            builder.setWool(validateBooleanInput("Есть ли шерсть? (да/нет): "));
            animals[i] = builder.createAnimal();
        }
        return animals;
    }

    @Override
    public Barrel[] fillArrayByBarrels() {
        Barrel[] barrels = new Barrel[arrayLen];
        BuildBarrel builder = new BuildBarrel();

        for (int i = 0; i < arrayLen; i++) {
            builder.setVolume(validateIntInput("Введите объем бочки (в литрах): "));
            builder.setContent(validateStringInput("Введите хранимый материал: "));
            builder.setMaterial(validateStringInput("Введите материал, из которого изготовлена бочка: "));
            barrels[i] = builder.createBarrel();
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans() {
        Human[] persons = new Human[arrayLen];
        BuildHuman builder = new BuildHuman();

        for (int i = 0; i < arrayLen; i++) {
            builder.setGender(validateStringInput("Введите пол: "));
            builder.setAge(validateIntInput("Введите возраст: "));
            builder.setSurname(validateStringInput("Введите фамилию: "));
            persons[i] = builder.createHuman();
        }
        return persons;
    }

    private String validateStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
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
        while (!input.equals("да") && !input.equals("нет")) {
            System.out.print("Некорректный ввод. Введите 'да' или 'нет': ");
            input = scanner.nextLine().toLowerCase();
        }
        return input.equals("да");
    }
}
