package com.example.test.DTO;

import com.example.test.Model.Doctor;

import java.util.Date;

public class OPDObservationDTO {
    Doctor doctors;
    Double cashRecieved;
    Long discount;
    Double total;
    Long id;
    Long fees;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public OPDObservationDTO() {
    }

    public OPDObservationDTO(Doctor doctors, Double cashRecieved, Long discount, Double total, Long id, Long fees, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.doctors = doctors;
        this.cashRecieved = cashRecieved;
        this.discount = discount;
        this.total = total;
        this.id = id;
        this.fees = fees;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
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

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date updateAt) {
        UpdateAt = updateAt;
    }
}
