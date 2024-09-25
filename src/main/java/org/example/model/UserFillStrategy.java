package org.example.model;

import org.example.director.Director;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import org.example.buildEntity.*;

import java.util.Scanner;

//TODO Implement class
public class UserFillStrategy implements FillStrategy {

    Director director = new Director();
    BuildAnimal buildAnimal = new BuildAnimal();
    BuildBarrel buildBarrel = new BuildBarrel();
    BuildHuman buildHuman = new BuildHuman();
    @Override
    public Animal[] fillArrayByAnimals() {
        Animal[] animals;
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество создоваемых элементов");
            animals = new Animal[scanner.nextInt()];
        for (int i = 0; i < animals.length; i++) {
                director.createAnimal(buildAnimal);
                animals[i] = buildAnimal.createAnimal();
            }
            return animals;
    }
    @Override
    public Barrel[] fillArrayByBarrels() {
        Barrel[] barrels;
        Scanner scanner = new Scanner(System.in) ;
            System.out.println("Введите количество создоваемых элементов");
            barrels = new Barrel[scanner.nextInt()];
        for (int i = 0; i < barrels.length; i++) {
                director.createBarrel(buildBarrel);
                barrels[i] = buildBarrel.createBarrel();
            }
        return barrels;
    }
    @Override
    public Human[] fillArrayByHumans() {
        Human[] humans;
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество создоваемых элементов");
            humans = new Human[scanner.nextInt()];
        for (int i = 0; i < humans.length; i++) {
                director.createHuman(buildHuman);
                humans[i] = buildHuman.createHuman();
            }
        return humans;
    }
}
