package org.example.model;

import org.example.director.Director;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;
import java.util.Random;

public class RandomObjectGenerator {
    private final String[] animalSpecies = {"cat", "dog", "cow", "snake"};
    private final String[] animalEyeColor = {"blue", "black", "gray", "green"};
    private final String[] barrelContents = {"long", "short", "not", "feather"};
    private final String[] barrelMaterials = {"wood", "metal", "plastic", "glass"};
    private final String[] humanGenders = {"male", "female", "non-binary"};
    private final String[] humanSurnames = {"Smith", "Johnson", "Williams", "Jones"};
    private final Director director = new Director();
    private final Random random = new Random();

    public Animal generateRandomAnimal() {
        String species = getRandomFromArray(animalSpecies);
        String eyeColor = getRandomFromArray(animalEyeColor);
        boolean wool = random.nextBoolean();
        return director.createAnimal(species, eyeColor, wool);
    }

    public Barrel generateRandomBarrel() {
        int volume = random.nextInt(100);
        String content = getRandomFromArray(barrelContents);
        String material = getRandomFromArray(barrelMaterials);
        return director.createBarrel(volume, content, material);
    }

    public Human generateRandomHuman() {
        String gender = getRandomFromArray(humanGenders);
        int age = random.nextInt(100);
        String surname = getRandomFromArray(humanSurnames);
        return director.createHuman(gender, age, surname);
    }

    private <T> T getRandomFromArray(T[] array) {
        return array[random.nextInt(array.length)];
    }
}
