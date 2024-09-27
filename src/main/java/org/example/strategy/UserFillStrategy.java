package org.example.strategy;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.buildEntity.UserObjectFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO Implement class
public class UserFillStrategy implements FillStrategy {
    private final UserObjectFactory userObjectGenerator;
    private final int arrayLength;

    public UserFillStrategy() {
        this.userObjectGenerator = new UserObjectFactory();
        this.arrayLength = getInputArrayLength();
    }

    private int getInputArrayLength() {
        System.out.println("Введите количество элементов:");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите число");
            return getInputArrayLength();
        }
    }


    @Override
    public Animal[] fillArrayByAnimals() {
        Animal[] animals = new Animal[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            animals[i] = userObjectGenerator.createAnimal();
        }

        return animals;
    }

    @Override
    public Barrel[] fillArrayByBarrels() {
        Barrel[] barrels = new Barrel[arrayLength];

        for (int i = 0; i < arrayLength; i++) {

            barrels[i] = userObjectGenerator.createBarrel();
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans() {
        Human[] persons = new Human[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            persons[i] = userObjectGenerator.createHuman();
        }
        return persons;
    }
}
