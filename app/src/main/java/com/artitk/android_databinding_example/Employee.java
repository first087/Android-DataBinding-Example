package com.artitk.android_databinding_example;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;

import com.artitk.android_databinding_example.BR;

public class Employee extends BaseObservable {
    private String name;
    private int age;
    public ObservableField<GenderEnum> gender = new ObservableField<>();

    public enum GenderEnum {UNKNOWN, MALE, FEMALE}

    public Employee(String name, int age, GenderEnum gender) {
        this.name = name;
        this.age = age;
        this.gender.set(gender);
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
                if (!name.equals(s.toString())) name = s.toString();
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
                int newAge = s.length() > 0 ? Integer.parseInt(s.toString()) : 0;
                if (age != newAge) age = newAge;
            }
        };
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
//        notifyChange(); Use this method when more property change
    }

    public CompoundButton.OnCheckedChangeListener getGenderListener() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) return;

                int id = buttonView.getId();
                switch (id) {
                    case R.id.rdo_unknown:  gender.set(GenderEnum.UNKNOWN); break;
                    case R.id.rdo_male:     gender.set(GenderEnum.MALE);    break;
                    case R.id.rdo_female:   gender.set(GenderEnum.FEMALE);  break;
                }
            }
        };
    }

    @Override
    public String toString() {
        return "name = " + name + "\nage = " + age + "\ngender = " + gender.get();
    }
}
