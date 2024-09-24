package org.example.entity;

import com.fasterxml.jackson.annotation.JsonSetter;

//TODO Implement class
public class Human implements Comparable<Human>, SupportedTypes {
    @JsonSetter("gender")
    private final String gender;
    @JsonSetter("age")
    private final int age;
    @JsonSetter("surname")
    private final String surname;

    public Human(String gender, int age, String surname) {
        this.gender = gender;
        this.age = age;
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public String toString() {
        return "Human{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        return 0;
    }
}
