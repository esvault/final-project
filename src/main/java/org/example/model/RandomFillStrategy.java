package org.example.model;


import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

import java.util.Random;
import java.util.Scanner;

//TODO Implement class
public class RandomFillStrategy implements FillStrategy {
    private int arrayLen;

    {
        System.out.println("Enter length of array");
        Scanner sc = new Scanner(System.in);
        arrayLen = sc.nextInt();

    }
    @Override
    public Animal[] fillArrayByAnimals() {
        Animal[] result = new Animal[arrayLen];

        return result;
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
