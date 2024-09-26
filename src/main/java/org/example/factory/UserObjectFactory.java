package org.example.factory;

import org.example.director.Director;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.utils.Validator;
import java.util.Scanner;
import java.util.function.Predicate;

public class UserObjectFactory implements ObjectFactory {
    private final Director director = new Director();
    private final Scanner scanner;

    public UserObjectFactory() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Animal createAnimal() {
        String species = validateString("Введите вид животного: ");
        String eyeColor = validateString("Введите цвет глаз: ");
        boolean wool = validateBooleanInput("Есть ли шерсть? (yes/no): ");
        return director.createAnimal(species, eyeColor, wool);
    }

    @Override
    public Barrel createBarrel() {
        int volume = validateVolume("Введите объем бочки (в литрах): ");
        String content = validateString("Введите хранимый материал: ");
        String material = validateString("Введите материал, из которого изготовлена бочка: ");
        return director.createBarrel(volume, content, material);
    }

    @Override
    public Human createHuman() {
        String gender = validateString("Введите пол: ");
        int age = validateAge("Введите возраст: ");
        String surname = validateSurname("Введите фамилию: ");
        return director.createHuman(gender, age, surname);
    }

    private String validateString(String prompt) {
        return validateInput(prompt, Validator::containsOnlyLetters);
    }

    private String validateSurname(String prompt) {
        return validateInput(prompt, Validator::validateSurname);
    }

    private int validateVolume(String prompt) {
        return Integer.parseInt(validateInput(prompt, Validator::validateVolume));
    }

    private int validateAge(String prompt) {
        return Integer.parseInt(validateInput(prompt, Validator::validateAge));
    }

    private boolean validateBooleanInput(String prompt) {
        return validateInput(prompt, Validator::validateBoolean).equals("yes");
    }

    // Predicate — функциональный интерфейс для проверки соблюдения некоторого условия.
    private String validateInput(String prompt, Predicate<String> validator) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!validator.test(input)) {
            System.out.print("Некорректный ввод. Попробуйте еще раз: ");
            input = scanner.nextLine();
        }
        return input;
    }
}
