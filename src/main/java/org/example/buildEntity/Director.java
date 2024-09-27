package org.example.buildEntity;

import org.example.entity.Animal;
import org.example.entity.Barrel;
import org.example.entity.Human;

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
