package org.example.buildEntity;

import org.example.entity.Human;

public class BuildHuman  {
    private String gender;
    private int age;
    private String surname;
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Human createHuman() {
        return new Human(gender, age, surname);
    }
}