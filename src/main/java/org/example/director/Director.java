package org.example.director;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.buildEntity.Builder;

import java.util.Scanner;

public class Director {
    public void createAnimal(BuildAnimal builder){
            builder.setSpecies(validateStringInput("Введите вид животного: "));
            builder.setEyeColor(validateStringInput("Введите цвет глаз: "));
            builder.setWool(validateBooleanInput("Есть ли шерсть? (да/нет): "));
    }
    public void createBarrel(BuildBarrel builder) {
            builder.setVolume(validateIntInput("Введите объем бочки (в литрах): "));
            builder.setContent(validateStringInput("Введите хранимый материал: "));
            builder.setMaterial(validateStringInput("Введите материал, из которого изготовлена бочка: "));
    }
    public void createHuman(BuildHuman builder) {
            builder.setGender(validateStringInput("Введите пол: "));
            builder.setAge(validateIntInput("Введите возраст: "));
            builder.setSurname(validateStringInput("Введите фамилию: "));
    }
    private String validateStringInput(String prompt) {
        System.out.print(prompt);
        try (Scanner scanner = new Scanner(System.in)) {
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            input = scanner.nextLine();
        }
        return input;
    }
    }

    private int validateIntInput(String prompt) {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try (Scanner scanner = new Scanner(System.in)) {
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
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            while (!input.equalsIgnoreCase("да") && !input.equalsIgnoreCase("нет")) {
                System.out.print("Некорректный ввод. Введите 'да' или 'нет': ");
                input = scanner.nextLine().toLowerCase();
            }

            return input.equals("да");
        }
    }
}
