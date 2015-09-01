package com.artitk.android_databinding_example;

public class Employee {
    private String name;
    private int age;
    private GenderEnum gender;

    public enum GenderEnum {UNKNOWN, MALE, FEMALE}

    public Employee(String name, int age, GenderEnum gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name = " + name + "\nage = " + age + "\ngender = " + gender;
    }
}
