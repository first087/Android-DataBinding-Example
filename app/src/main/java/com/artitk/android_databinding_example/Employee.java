package com.artitk.android_databinding_example;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.artitk.android_databinding_example.BR;

public class Employee extends BaseObservable {
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

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
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
