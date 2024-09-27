package org.example.buildEntity;

import org.example.entity.Animal;

public class BuildAnimal  {
    private String species;
    private String eyeColor;
    private boolean wool;


    public BuildAnimal setSpecies(String species) {
        this.species = species;
        return this;
    }


    public BuildAnimal setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }


    public BuildAnimal setWool(boolean wool) {
        this.wool = wool;
        return this;
    }

    public Animal createAnimal() {
        return new Animal(species, eyeColor, wool);
    }
}
