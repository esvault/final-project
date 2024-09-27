package org.example.entity;

//TODO Implement class
public class Animal implements SupportedTypes {
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
    public int compareTo(Object o) {
        Animal other = (Animal) o;
        if (!species.equals(other.species)) {
            return species.compareTo(other.species);
        }
        if (!eyeColor.equals(other.eyeColor)) {
            return eyeColor.compareTo(other.eyeColor);
        }
        return Boolean.compare(wool, other.wool);
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
