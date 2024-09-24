package org.example.director;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.buildEntity.Builder;

import java.util.Scanner;

public class Director {
    public void createAnimal(BuildAnimal builder){
        try (Scanner scanner = new Scanner(System.in)) {
            builder.setSpecies(scanner.nextLine());
            builder.setEyeColor(scanner.nextLine());
            builder.setWool(Boolean.parseBoolean(scanner.nextLine()));
        }
    }
    public void createBarrel(BuildBarrel builder) {
        try (Scanner scanner = new Scanner(System.in)) {
            builder.setVolume(scanner.nextInt());
            builder.setContent(scanner.nextLine());
            builder.setMaterial(scanner.nextLine());
        }
    }
    public void createHuman(BuildHuman builder) {
        try (Scanner scanner = new Scanner(System.in)) {
            builder.setGender(scanner.nextLine());
            builder.setAge(scanner.nextInt());
            builder.setSurname(scanner.nextLine());
        }
    }
}
