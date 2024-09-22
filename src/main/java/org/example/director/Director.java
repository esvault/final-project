package org.example.director;

import org.example.buildEntity.Builder;

import java.util.Scanner;

public class Director {
    public void createAnimal(Builder builder){
        try (Scanner scanner = new Scanner(System.in)) {
            builder.setFirstParam(scanner.nextLine());
            builder.setSecondParam(scanner.nextLine());
            builder.setLastParam(scanner.nextLine());
        }
    }
    public void createBarrel(Builder builder) {
        try (Scanner scanner = new Scanner(System.in)) {
            builder.setFirstParam(scanner.nextLine());
            builder.setSecondParam(scanner.nextLine());
            builder.setLastParam(scanner.nextLine());
        }
    }
    public void createHuman(Builder builder) {
        try (Scanner scanner = new Scanner(System.in)) {
            builder.setFirstParam(scanner.nextLine());
            builder.setSecondParam(scanner.nextLine());
            builder.setLastParam(scanner.nextLine());
        }
    }
}
