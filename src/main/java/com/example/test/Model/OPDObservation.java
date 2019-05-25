package com.example.test.Model;

public class OPDObservation {
    String [] doctors;
    Long discount;
    Long fees;

    public OPDObservation() {
    }

    public OPDObservation(String[] doctors, Long discount, Long fees) {
        this.doctors = doctors;
        this.discount = discount;
        this.fees = fees;
    }

    public String[] getDoctors() {
        return doctors;
    }

    public void setDoctors(String[] doctors) {
        this.doctors = doctors;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
    }
}



