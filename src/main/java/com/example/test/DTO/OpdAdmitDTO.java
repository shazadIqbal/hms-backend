package com.example.test.DTO;

import com.example.test.Model.Bed;

import java.util.Date;

public class OpdAdmitDTO {
     Long bedID; //bed id
     Long patientID; //patiendID
     Double price;   //price field
     Double cashRecieved; //cash
     String bedType;  //general or speical or any other
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;


    public OpdAdmitDTO() {
    }

    public Long getBedID() {
        return bedID;
    }

    public void setBedID(Long bedID) {
        this.bedID = bedID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCashRecieved() {
        return cashRecieved;
    }

    public void setCashRecieved(Double cashRecieved) {
        this.cashRecieved = cashRecieved;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
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

    public OpdAdmitDTO(Long bedID, Long patientID, Double price, Double cashRecieved, String bedType, String createdBy, String updatedBy, Date createdAt, Date updateAt) {

        this.bedID = bedID;
        this.patientID = patientID;
        this.price = price;
        this.cashRecieved = cashRecieved;
        this.bedType = bedType;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }
}

