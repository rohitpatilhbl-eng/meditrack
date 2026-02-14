package com.airtribe.meditrack.test;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.service.*;

import java.time.LocalDateTime;

public class TestRunner {

    public static void main(String[] args) {

        System.out.println("===== RUNNING MANUAL TESTS =====");

        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();

        Patient p1 = new Patient(1, "Test Patient", 25, "Cold");
        Patient p2 = p1.clone();

        System.out.println("Original Patient: " + p1.getName());
        System.out.println("Cloned Patient: " + p2.getName());

        Doctor doctor = new Doctor(1, "Dr. Sharma", 45,
                Specialization.CARDIOLOGIST, 800);

        doctorService.addDoctor(doctor);

        System.out.println("Doctor Added: " + doctor.getName());


        patientService.addPatient(p1);
        System.out.println("Patient Added: " + p1.getName());


        appointmentService.createAppointment(
                p1,
                doctor,
                LocalDateTime.now().toString()
        );

        System.out.println("Appointments Count: "
                + appointmentService.getAllAppointments().size());


        Appointment appt = appointmentService.getAllAppointments().get(0);

        Bill bill = new Bill(
                1,
                appt.getPatient(),
                appt.getDoctor(),
                appt.getDoctor().getConsultationFee()
        );

        BillSummary summary = bill.generateSummary();

        System.out.println("Bill Generated:");
        System.out.println(summary);

        System.out.println("===== ALL TESTS COMPLETED SUCCESSFULLY =====");
    }
}
