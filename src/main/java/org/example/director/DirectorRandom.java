package org.example.director;

import org.example.buildEntity.Builder;

import java.util.Random;
import java.util.Scanner;

public class DirectorRandom {
    Random rand = new Random();
    public void createRandomAnimal(Builder builder){
            builder.setFirstParam(rand.nextInt(10));
            builder.setSecondParam(scanner.nextLine());
            builder.setLastParam(scanner.nextLine());
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
