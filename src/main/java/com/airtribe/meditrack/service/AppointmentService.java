package com.airtribe.meditrack.service;

import java.time.LocalDateTime;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.AppointmentStatus;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService {

    private final DataStore<Appointment> appointmentStore;

    public AppointmentService() {
        this.appointmentStore = new DataStore<>();
    }

    public void createAppointment(Patient patient, Doctor doctor, String dateTime) {

        int id = IdGenerator.getInstance().generateId();

        Appointment appointment = new Appointment(
                id,
                doctor,                         // doctor first
                patient,                        // patient second
                LocalDateTime.parse(dateTime)   // convert String → LocalDateTime
        );

        appointment.confirm();

        appointmentStore.add(appointment);
    }




    public List<Appointment> getAllAppointments() {
        return appointmentStore.getAll();
    }

    public Appointment getAppointment(int id) {
        return appointmentStore.getAll()
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new AppointmentNotFoundException("Appointment not found with id: " + id));
    }

    public void confirmAppointment(int id) {
        Appointment appointment = getAppointment(id);
        appointment.confirm();
    }

    public void cancelAppointment(int id) {
        Appointment appointment = getAppointment(id);
        appointment.cancel();
    }

    public void deleteAppointment(int id) {
        Appointment appointment = getAppointment(id);
        appointmentStore.remove(appointment);
    }

    public long getAppointmentCountForDoctor(int doctorId) {
        return appointmentStore.getAll()
                .stream()
                .filter(a -> a.getDoctor().getId() == doctorId)
                .count();
    }


    public List<Appointment> getAppointmentsByStatus(AppointmentStatus status) {
        return appointmentStore.getAll()
                .stream()
                .filter(a -> a.getStatus() == status)
                .collect(Collectors.toList());
    }
}
