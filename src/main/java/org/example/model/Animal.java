package org.example.model;

//TODO Implement class
public class Animal implements Comparable<Animal>, SupportedTypes {
    private int species;
    private int eyeColor;
    private Boolean wool;

    public void setWool(Boolean wool) {
        this.wool = wool;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setSpecies(int species) {
        this.species = species;
    }

    @Override
    public int compareTo(Animal o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species=" + species +
                ", eyeColor=" + eyeColor +
                ", wool=" + wool +
                '}';
    }
}
