package com.example.test.DTO;

import java.util.Date;

public class PatientDTO {
    private Long id;
    private String name;
    private String cnic;
    private String phoneNo;
    private  Integer age;
    private String gender;
    private String address;
    private String status;
    private Boolean gynAndObsRegistration;
    private String husbandOfAndFatherOf;
    private Date registrationDate;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;
    private Boolean discharge;
    private Long bedId;

    public PatientDTO() {

    }

    public PatientDTO(Long id, String name, String cnic, String phoneNo, Integer age, String gender, String address, String status, Boolean gynAndObsRegistration, String husbandOfAndFatherOf, Date registrationDate, String createdBy, String updatedBy, Date createdAt, Date updateAt, Boolean discharge, Long bedId) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.status = status;
        this.gynAndObsRegistration = gynAndObsRegistration;
        this.husbandOfAndFatherOf = husbandOfAndFatherOf;
        this.registrationDate = registrationDate;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
        this.discharge = discharge;
        this.bedId = bedId;
    }

    public Boolean getDischarge() {
        return discharge;
    }

    public void setDischarge(Boolean discharge) {
        this.discharge = discharge;
    }

    public Long getBedId() {
        return bedId;
    }

    public void setBedId(Long bedId) {
        this.bedId = bedId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getGynAndObsRegistration() {
        return gynAndObsRegistration;
    }

    public void setGynAndObsRegistration(Boolean gynAndObsRegistration) {
        this.gynAndObsRegistration = gynAndObsRegistration;
    }

    public String getHusbandOfAndFatherOf() {
        return husbandOfAndFatherOf;
    }

    public void setHusbandOfAndFatherOf(String husbandOfAndFatherOf) {
        this.husbandOfAndFatherOf = husbandOfAndFatherOf;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
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
