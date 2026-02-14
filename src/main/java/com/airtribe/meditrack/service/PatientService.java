package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.interfaces.Searchable;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.IdGenerator;

import java.util.List;

public class PatientService implements Searchable<Patient> {

    private final DataStore<Patient> patientStore = new DataStore<>();

    public void addPatient(Patient patient) {
        int id = IdGenerator.getInstance().generateId();
        patient.setId(id);
        patientStore.add(patient);

        System.out.println("Patient ID created: " + id);
    }


    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }

    @Override
    public List<Patient> search(String keyword) {
        return patientStore.getAll()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(keyword))
                .toList();
    }

    public Patient searchPatient(int id) {
        for (Patient patient : patientStore.getAll()) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }
}
