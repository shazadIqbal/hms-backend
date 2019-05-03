package com.example.test.DTO;

import com.example.test.Model.Bed;

public class OpdAdmitDTO {
     Long bedID; //bed id
     Long patientID; //patiendID
     Double price;   //price field
     Double cashRecieved; //cash
     String bedType;  //general or speical or any other



    public OpdAdmitDTO(Long bedID, Long patientID, Double price, Double cashRecieved, String bedType) {
        this.bedID = bedID;
        this.patientID = patientID;
        this.price = price;
        this.cashRecieved = cashRecieved;
        this.bedType = bedType;
//        this.selectedBed = selectedBed;
    }

    public OpdAdmitDTO() {
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


}

