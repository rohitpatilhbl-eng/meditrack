package com.airtribe.meditrack.entity;
import com.airtribe.meditrack.util.Validator;


public class Patient extends Person {

    private String disease;

    public Patient(int id, String name, int age, String disease) {

        Validator.validateName(name);
        Validator.validateAge(age);

        super(id, name, age);
        this.disease = disease;
    }


    @Override
    public String getRole() {
        return "Patient";
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public Patient clone() {
        return new Patient(getId(), getName(), getAge(), getDisease());
    }

    public void setId(int id) {
        this.id = id;
    }

}
