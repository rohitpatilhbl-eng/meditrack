package com.airtribe.meditrack.entity;

public final class BillSummary {

    private final int billId;
    private final String patientName;
    private final String doctorName;
    private final double consultationFee;
    private final double totalAmount;

    public BillSummary(int billId, String patientName, String doctorName,
                       double consultationFee, double totalAmount) {

        this.billId = billId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.consultationFee = consultationFee;
        this.totalAmount = totalAmount;
    }

    public int getBillId() {
        return billId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "BillSummary{" +
                "billId=" + billId +
                ", patient='" + patientName + '\'' +
                ", doctor='" + doctorName + '\'' +
                ", consultationFee=" + consultationFee +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
