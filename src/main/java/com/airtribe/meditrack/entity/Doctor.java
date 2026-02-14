package com.airtribe.meditrack.entity;
import com.airtribe.meditrack.util.Validator;


public class Doctor extends Person {

    private Specialization specialization;
    private double consultationFee;

    public Doctor(int id, String name, int age, Specialization specialization, double consultationFee) {

        Validator.validateName(name);
        Validator.validateAge(age);
        Validator.validateFee(consultationFee);

        super(id, name, age);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }


    @Override
    public String getRole() {
        return "Doctor";
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
}
