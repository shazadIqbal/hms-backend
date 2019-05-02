package com.example.test.Model;

public class OPDObservation {
    String [] doctors;
    Long discount;
    Long sallary;

    public OPDObservation() {
    }

    public OPDObservation(String[] doctors, Long discount, Long sallary) {
        this.doctors = doctors;
        this.discount = discount;
        this.sallary = sallary;
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

    public Long getSallary() {
        return sallary;
    }

    public void setSallary(Long sallary) {
        this.sallary = sallary;
    }
}


