package com.artitk.android_databinding_example;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;

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

    public TextWatcher getNameWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                name = s.toString();
            }
        };
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public TextWatcher getAgeWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                age = s.length() > 0 ? Integer.parseInt(s.toString()) : 0;
            }
        };
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public GenderEnum getGender() {
        return gender;
    }

    public CompoundButton.OnCheckedChangeListener getGenderListener() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) return;

                int id = buttonView.getId();
                switch (id) {
                    case R.id.rdo_unknown:  gender = GenderEnum.UNKNOWN;    break;
                    case R.id.rdo_male:     gender = GenderEnum.MALE;       break;
                    case R.id.rdo_female:   gender = GenderEnum.FEMALE;     break;
                }
            }
        };
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name = " + name + "\nage = " + age + "\ngender = " + gender;
    }
}
