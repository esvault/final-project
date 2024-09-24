package org.example.buildEntity;

import org.example.entity.Animal;

public class BuildAnimal  {
    private String species;
    private String eyeColor;
    private Boolean wool;


    public void setSpecies(String species) {
        this.species = species;
    }


    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }


    public void setWool(Boolean wool) {
        this.wool = wool;
    }

    public Animal createAnimal() {
        return new Animal(species, eyeColor, wool);
    }
}
