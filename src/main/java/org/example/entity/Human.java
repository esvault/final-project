package org.example.entity;

//TODO Implement class
public class Human implements Comparable<Human>, SupportedTypes {
    private final String gender;
    private final int age;
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
    public int compareTo(Human o) {
        if (gender.equals(o.gender)) {
            return gender.compareTo(o.gender);
        }
        if (age != o.age) {
            return age - o.age;
        }
        return surname.compareTo(o.surname);
    }

    @Override
    public String toString() {
        return "Human{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", surname='" + surname + '\'' +
                '}';
    }
}
