package org.example.model;

import org.example.director.Director;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.utils.Validator;

import java.util.Scanner;

public class UserObjectGenerator {
    private final Director director = new Director();
    private final Scanner scanner;

    public UserObjectGenerator() {
        scanner = new Scanner(System.in);
    }

    public Animal generateAnimal() {
        String species = validateString("Введите вид животного: ");
        String eyeColor = validateString("Введите цвет глаз: ");
        boolean wool = validateBooleanInput("Есть ли шерсть? (да/нет): ");
        return director.createAnimal(species, eyeColor, wool);
    }

    public Barrel generateBarrel() {
        int volume = validateVolume("Введите объем бочки (в литрах): ");
        String content = validateString("Введите хранимый материал: ");
        String material = validateString("Введите материал, из которого изготовлена бочка: ");
        return director.createBarrel(volume, content, material);
    }

    public Human generateHuman() {
        String gender = validateString("Введите пол: ");
        int age = validateAge("Введите возраст: ");
        String surname = validateString("Введите фамилию: ");
        return director.createHuman(gender, age, surname);
    }

    private String validateString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!Validator.containsOnlyLetters(input)) {
            System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            input = scanner.nextLine();
        }
        return input;
    }

    private String validateSurname(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!Validator.validateSurname(input)) {
            System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            input = scanner.nextLine();
        }
        return input;
    }

    private int validateVolume(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!Validator.validateVolume(input)) {
            System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    private int validateAge(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!Validator.validateAge(input)) {
            System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    private boolean validateBooleanInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!Validator.validateBoolean(input)) {
            System.out.print("Некорректный ввод. Введите 'yes'/'no' or 'true'/'false': ");
            input = scanner.nextLine();
        }
        return input.equals("yes") || input.equals("true");
    }
}
