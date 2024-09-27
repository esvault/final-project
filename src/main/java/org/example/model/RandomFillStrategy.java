package org.example.model;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.factory.RandomObjectFactory;

import java.util.Scanner;

//TODO Implement class
public class RandomFillStrategy implements FillStrategy {
    private final RandomObjectFactory randomObjectGenerator;
    private final int arrayLength;

    public RandomFillStrategy() {
        this.randomObjectGenerator = new RandomObjectFactory();
        this.arrayLength = getInputArrayLength();
    }

    private int getInputArrayLength() {
        System.out.println("Введите количество создаваемых элементов:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public Animal[] fillArrayByAnimals() {
        Animal[] animals = new Animal[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            animals[i] = randomObjectGenerator.createAnimal();
        }

        return animals;
    }

    @Override
    public Barrel[] fillArrayByBarrels() {
        Barrel[] barrels = new Barrel[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            barrels[i] = randomObjectGenerator.createBarrel();
        }

        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans() {
        Human[] humans = new Human[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            humans[i] = randomObjectGenerator.createHuman();

        }

        return humans;
    }
}
