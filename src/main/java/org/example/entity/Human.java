package org.example.entity;

//TODO Implement class
public class Human implements SupportedTypes {
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
    public int compareTo(Object o) {
        Human other = (Human) o;
        if (!gender.equals(other.gender)) {
            return gender.compareTo(other.gender);
        }
        if (age != other.age) {
            return age - other.age;
        }
        return surname.compareTo(other.surname);
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
