package org.example.model;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.director.Director;
import org.example.director.DirectorRandom;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

import java.util.Random;
import java.util.Scanner;

//TODO Implement class
public class RandomFillStrategy implements FillStrategy {
    private final String[] animalSpecies = {"kat","dog","cow","snake"};
    private final String[] animalEyeColor = {"blue","black","gray","green"};
    private final String[] barrelContent = {"long","short","not","feather"};
    private final String[] barrelMaterial = {"long","short","not","feather"};
    private final String[] humanGender = {"Apache combat helicopter","male","female","it"};
    private final String[]  humanSurname = {"long","short","not","feather"};
    private final Random rand = new Random();
    private int arrayLen = 0;
    private Director director;

    {
        System.out.println("Введите количество создаваемых элементов");
        Scanner sc = new Scanner(System.in);
        arrayLen = sc.nextInt();
    }

    @Override
    public Animal[] fillArrayByAnimals() {
        Animal[] animals = new Animal[arrayLen];

        for (int i = 0; i < animals.length; i++) {
            String species = animalSpecies[rand.nextInt(animalSpecies.length)];
            String eyeColor = animalEyeColor[rand.nextInt(animalEyeColor.length)];
            boolean wool = rand.nextInt(10) > 5;
            animals[i] = director.createAnimal(species, eyeColor, wool);
        }

        return animals;
    }

    @Override
    public Barrel[] fillArrayByBarrels() {
        Barrel[] barrels = new Barrel[arrayLen];

        for (int i = 0; i < barrels.length; i++) {
            int volume = rand.nextInt(6);
            String content = barrelContent[rand.nextInt(barrelContent.length)];
            String material = barrelMaterial[rand.nextInt(barrelMaterial.length)];
            barrels[i] = director.createBarrel(volume, content, material);
        }

        return barrels;
    }

    @Override
    public Human[] fillArrayByHumans() {
        Human[] humans = new Human[arrayLen];

        for (int i = 0; i < humans.length; i++) {
            String gender = humanGender[rand.nextInt(humanGender.length)];
            int content = rand.nextInt(100);
            String surname = humanSurname[rand.nextInt(humanSurname.length)];
            humans[i] = director.createHuman(gender, content, surname);
        }

        return humans;
    }
}
