package org.example.buildEntity;

import org.example.entity.Human;

public class BuildHuman implements Builder {
    private String gender;
    private int age;
    private String surname;

    @Override
    public void setFirstParam(String gender) {
        this.gender = gender;
    }

    @Override
    public void setSecondParam(String age) {
        this.age = Integer.parseInt(age);
    }

    @Override
    public void setLastParam(String surname) {
        this.surname = surname;
    }

    public Human createHuman() {
        return new Human(gender, age, surname);
    }
}
