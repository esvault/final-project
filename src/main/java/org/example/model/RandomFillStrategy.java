package org.example.model;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.director.DirectorRandom;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

import java.util.Scanner;

//TODO Implement class
public class RandomFillStrategy implements FillStrategy {
    DirectorRandom directorRandom = new DirectorRandom();
    BuildAnimal buildAnimal = new BuildAnimal();
    BuildBarrel buildBarrel = new BuildBarrel();
    BuildHuman buildHuman = new BuildHuman();

    @Override
    public Animal[] fillArrayByAnimals() {

        Animal[] animals;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество создоваемых элементов");
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

        Barrel[] barrels;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество создоваемых элементов");
            barrels = new Barrel[scanner.nextInt()];
            for (int i = 0; i < barrels.length; i++) {
                directorRandom.createRandomBarrel(buildBarrel);
                barrels[i] = buildBarrel.createBarrel();
            }
        }
        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans() {

        Human[] humans;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество создоваемых элементов");
            humans = new Human[scanner.nextInt()];
            for (int i = 0; i < humans.length; i++) {
                directorRandom.createRandomHuman(buildHuman);
                humans[i] = buildHuman.createHuman();
            }
        }
        return humans;
    }
}
