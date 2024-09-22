package org.example.director;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.Builder;

import java.util.Random;
import java.util.Scanner;
// Избавиться от интерфейса в реализации билдера (ничего не понятно в директоре)
//создать массивы с вариантами значений стринговых полей ()
public class DirectorRandom {
    String[] animalSpecies = {"kat","dog","cow","snake"};
    String[] animalEyeColor = {"blue","black","gray","green"};
    String[] animalWool = {"long","short","not","feather"};
    Random rand = new Random();
    public void createRandomAnimal(BuildAnimal builder){
            builder.setSpecies(animalSpecies[rand.nextInt(animalSpecies.length)]);
            builder.setEyeColor(animalEyeColor[rand.nextInt(animalEyeColor.length)]);
            builder.setWool(animalWool[rand.nextInt(animalWool.length)]);
            builder.createAnimal();
    }
    public void createRandomBarrel(Builder builder) {
            builder.setFirstParam(scanner.nextLine());
            builder.setSecondParam(scanner.nextLine());
            builder.setLastParam(scanner.nextLine());
    }
    public void createRandomHuman(Builder builder) {
            builder.setFirstParam(scanner.nextLine());
            builder.setSecondParam(scanner.nextLine());
            builder.setLastParam(scanner.nextLine());
    }
}
