package org.example.buildEntity;

import org.example.entity.Human;

public class BuildHuman  {
    private String gender;
    private int age;
    private String surname;

    public BuildHuman setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public BuildHuman setAge(int age) {
        this.age = age;
        return this;
    }

    public BuildHuman setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Human createHuman() {
        return new Human(gender, age, surname);
    }
}
