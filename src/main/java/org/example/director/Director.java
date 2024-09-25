package org.example.director;

import org.example.buildEntity.BuildAnimal;
import org.example.buildEntity.BuildBarrel;
import org.example.buildEntity.BuildHuman;
import org.example.buildEntity.Builder;
import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

import java.util.Scanner;

public class Director {
    public Animal createAnimal(String species, String eyeColor, boolean wool){
        return new BuildAnimal()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setWool(wool)
                .createAnimal();
    }

    public Barrel createBarrel(int volume, String content, String material) {
        return new BuildBarrel()
                .setVolume(volume)
                .setContent(content)
                .setMaterial(material)
                .createBarrel();
    }
    public Human createHuman(String gender, int age, String surname) {
        return new BuildHuman()
                .setGender(gender)
                .setAge(age)
                .setSurname(surname)
                .createHuman();
    }
}
