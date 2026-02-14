package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Specialization;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {

    private DataStore<Doctor> doctorStore;

    public DoctorService() {
        this.doctorStore = new DataStore<>();
    }

    public void addDoctor(Doctor doctor) {
        int id = IdGenerator.getInstance().generateId();
        doctor.setId(id);
        doctorStore.add(doctor);

        System.out.println("Doctor ID created: " + id);
    }



    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    public Doctor searchDoctor(int id) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Doctor> searchDoctor(String name) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Doctor> searchDoctor(Specialization specialization) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getSpecialization() == specialization)
                .collect(Collectors.toList());
    }

    public double getAverageConsultationFee() {
        return doctorStore.getAll()
                .stream()
                .mapToDouble(Doctor::getConsultationFee)
                .average()
                .orElse(0);
    }

    public void removeDoctor(Doctor doctor) {
        doctorStore.remove(doctor);
    }
}
