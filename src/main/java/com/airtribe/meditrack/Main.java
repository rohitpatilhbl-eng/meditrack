package com.airtribe.meditrack;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.service.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final DoctorService doctorService = new DoctorService();
    private static final PatientService patientService = new PatientService();
    private static final AppointmentService appointmentService = new AppointmentService();

    private static int billId = 1;

    static void main(String[] args) {

        System.out.println(" Welcome to MediTrack System");
        // Load data if argument passed
        if (args.length > 0 && args[0].equals("--loadData")) {

            var loadedPatients = com.airtribe.meditrack.util.CSVUtil.loadPatients();

            for (Patient p : loadedPatients) {
                patientService.addPatient(p);
            }
        }

        while (true) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> addPatient();
                case 3 -> bookAppointment();
                case 4 -> viewAppointments();
                case 5 -> generateBill();
                case 0 -> {
                    com.airtribe.meditrack.util.CSVUtil
                            .savePatients(patientService.getAllPatients());

                    System.out.println("Data saved ");
                    return;
                }

                default -> System.out.println("Invalid option");
            }
        }
    }


    private static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Book Appointment");
        System.out.println("4. View Appointments");
        System.out.println("5. Generate Bill");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    // ========================= DOCTOR =========================

    private static void addDoctor() {

        System.out.print("Doctor name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.println("Choose Specialization:");
        for (Specialization s : Specialization.values()) {
            System.out.println(s.ordinal() + " -> " + s);
        }

        int sp = scanner.nextInt();
        System.out.print("Consultation fee: ");
        double fee = scanner.nextDouble();
        scanner.nextLine();

        Doctor doctor = new Doctor(
                0,
                name,
                age,
                Specialization.values()[sp],
                fee
        );


        doctorService.addDoctor(doctor);

        System.out.println("Doctor added successfully!");
    }

    // ========================= PATIENT =========================

    private static void addPatient() {

        System.out.print("Patient name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Disease: ");
        String disease = scanner.nextLine();

        Patient patient = new Patient(
                0, // temporary
                name,
                age,
                disease
        );


        patientService.addPatient(patient);

        System.out.println("Patient added successfully!");
    }

    // ========================= APPOINTMENT =========================

    private static void bookAppointment() {

        System.out.print("Doctor ID: ");
        int dId = scanner.nextInt();

        System.out.print("Patient ID: ");
        int pId = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = doctorService.searchDoctor(dId);
        Patient patient = patientService.searchPatient(pId);

        if (doctor == null || patient == null) {
            System.out.println("Invalid doctor or patient ID");
            return;
        }

        appointmentService.createAppointment(
                patient,
                doctor,
                LocalDateTime.now().toString()
        );





        System.out.println("Appointment booked!");
    }

    private static void viewAppointments() {

        List<Appointment> list = appointmentService.getAllAppointments();

        if (list.isEmpty()) {
            System.out.println("No appointments found");
            return;
        }

        list.forEach(a ->
                System.out.println("ID: " + a.getId() +
                        " | Doctor: " + a.getDoctor().getName() +
                        " | Patient: " + a.getPatient().getName() +
                        " | Status: " + a.getStatus()));
    }

    // ========================= BILLING =========================

    private static void generateBill() {

        System.out.print("Appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Appointment appointment = appointmentService.getAppointment(id);

        Bill bill = new Bill(
                billId++,
                appointment.getPatient(),
                appointment.getDoctor(),
                appointment.getDoctor().getConsultationFee()
        );

        BillSummary summary = bill.generateSummary();

        System.out.println("\n===== BILL =====");
        System.out.println(summary);
    }
}
