package com.example.test.DTO;

import com.example.test.Model.Doctor;

public class OPDObservationDTO {
    Doctor doctors;
    Double cashRecieved;
    Long discount;
    Double total;
    Long id;
    Long fees;

    public OPDObservationDTO() {
    }

    public OPDObservationDTO(Doctor doctors, Double cashRecieved, Long discount, Double total, Long id, Long fees) {
        this.doctors = doctors;
        this.cashRecieved = cashRecieved;
        this.discount = discount;
        this.total = total;
        this.id = id;
        this.fees = fees;
    }

    public Doctor getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor doctors) {
        this.doctors = doctors;
    }

    public Double getCashRecieved() {
        return cashRecieved;
    }

    public void setCashRecieved(Double cashRecieved) {
        this.cashRecieved = cashRecieved;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
    }
}
