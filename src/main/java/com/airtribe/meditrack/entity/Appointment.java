package com.airtribe.meditrack.entity;

import java.time.LocalDateTime;

public class Appointment {

    private int id;
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dateTime;
    private AppointmentStatus status;

    public Appointment(int id, Doctor doctor, Patient patient, LocalDateTime dateTime) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.status = AppointmentStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void confirm() {
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    @Override
    public Appointment clone() {
        return new Appointment(
                id,
                doctor,
                patient,
                dateTime
        );
    }

}
