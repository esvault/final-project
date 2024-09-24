package org.example.entity;

//TODO Implement class
public class Animal implements Comparable<Animal>, SupportedTypes {
    private final String species;
    private final String eyeColor;
    private final Boolean wool;

    public Animal(String species, String eyeColor, Boolean wool) {
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

    public Boolean getWool() {
        return wool;
    }

    @Override
    public int compareTo(Animal o) {
        if (!species.equals(o.species)) {
            return species.compareTo(o.species);
        }
        if (!eyeColor.equals(o.eyeColor)) {
            return eyeColor.compareTo(o.eyeColor);
        }
        return Boolean.compare(wool, o.wool);
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
