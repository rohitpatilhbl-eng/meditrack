package com.airtribe.meditrack.util;

import com.airtribe.meditrack.entity.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    private static final String PATIENT_FILE = "patients.csv";

    public static void savePatients(List<Patient> patients) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENT_FILE))) {

            for (Patient p : patients) {
                writer.write(p.getId() + "," +
                        p.getName() + "," +
                        p.getAge() + "," +
                        p.getDisease());
                writer.newLine();
            }

            System.out.println("Patients saved to CSV");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Patient> loadPatients() {

        List<Patient> patients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String disease = parts[3];

                patients.add(new Patient(id, name, age, disease));
            }

            System.out.println("Patients loaded from CSV");

        } catch (IOException e) {
            System.out.println("No previous patient data found.");
        }

        return patients;
    }
}
