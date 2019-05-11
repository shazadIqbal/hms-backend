package com.example.test.Model;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

import java.util.Date;

@Entity
@Table(name="Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnic;
    private String phoneNo;
    private Integer age;
    private String gender;
    private String address;
    private String status;
    private String accountNo;
    private Boolean gynAndObsRegistration;
    private String husbandOfAndFatherOf;
    private Date registrationDate;

    private Date date;


    @OneToMany(mappedBy = "patient")
    private List<History> history;


    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public Patient() {
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Patient(String name, String cnic, String phoneNo, Integer age, String gender, String address, String status, Boolean gynAndObsRegistration,String husbandOfAndFatherOf,Date registrationDate ) {
        this.date=date;
        this.name = name;
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.status = status;
        this.gynAndObsRegistration= gynAndObsRegistration;
        this.husbandOfAndFatherOf=husbandOfAndFatherOf;
        this.registrationDate = registrationDate;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
