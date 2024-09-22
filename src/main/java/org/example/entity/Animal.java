package org.example.entity;

//TODO Implement class
public class Animal implements Comparable<Animal>, SupportedTypes {
    private final String species;
    private final String eyeColor;
    private final String wool;

    public Animal(String species, String eyeColor, String wool) {
        this.species = species;
        this.eyeColor = eyeColor;
        this.wool = wool;
    }

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getWool() {
        return wool;
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
