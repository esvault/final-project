package org.example.buildEntity;

import org.example.entity.Animal;

public class BuildAnimal implements Builder {
    private String species;
    private String eyeColor;
    private String wool;

    @Override
    public void setFirstParam(String species) {
        this.species = species;
    }

    @Override
    public void setSecondParam(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Override
    public void setLastParam(String wool) {
        this.wool = wool;
    }

    public Animal createAnimal() {
        return new Animal(species, eyeColor, wool);
    }
}
