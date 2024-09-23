package org.example.model;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.director.DirectorRandom;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

import java.util.Random;
import java.util.Scanner;

//TODO Implement class
public class RandomFillStrategy implements FillStrategy {

    @Override
    public Animal[] fillArrayByAnimals() {
        BuildAnimal buildAnimal = new BuildAnimal();
        DirectorRandom directorRandom = new DirectorRandom();
        Animal[] animals;
        try (Scanner scanner = new Scanner(System.in)) {
            animals = new Animal[scanner.nextInt()];
            for (int i = 0; i < animals.length; i++) {
                directorRandom.createRandomAnimal(buildAnimal);
                animals[i] = buildAnimal.createAnimal();
            }

        }
        return animals;
    }

    @Override
    public Barrel[] fillArrayByBarrels() {
        return null;
    }

    @Override
    public Human[] fillArrayByHumans() {
        return null;
    }
}
