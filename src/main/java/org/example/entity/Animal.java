package org.example.entity;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.example.entity.SupportedTypes;

//TODO Implement class
public class Animal implements Comparable<Animal>, SupportedTypes {
    @JsonSetter("species")
    private final String species;
    @JsonSetter("eyeColor")
    private final String eyeColor;
    @JsonSetter("wool")
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
