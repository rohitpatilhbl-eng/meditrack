package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.interfaces.Payable;

public class Bill implements Payable {

    private int billId;
    private Patient patient;
    private Doctor doctor;
    private double consultationFee;

    public Bill(int billId, Patient patient, Doctor doctor, double consultationFee) {
        this.billId = billId;
        this.patient = patient;
        this.doctor = doctor;
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateTotal() {
        double tax = consultationFee * Constants.TAX_RATE;
        return consultationFee + tax;
    }

    public BillSummary generateSummary() {
        return new BillSummary(
                billId,
                patient.getName(),
                doctor.getName(),
                consultationFee,
                calculateTotal()
        );
    }
}
