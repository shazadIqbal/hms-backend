package com.example.test.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long mrno;


    String  fullName;
    int mobile;
    int  emrNo;
    String nationality;
    String address;
    String daysservice;
    int cnic;
    String email;
    String speciality;
    String qualification;
    String hoursday;
    String position;
    String religion;
    int  sallary;
    String dateOfbirth;
    String gender;
    String timeIn;
    String timeOut;
    Date createdDate;

    public Doctor() {
    }

    public Doctor(String fullName, int mobile, int emrNo, String nationality, String address, String daysservice, int cnic, String email, String speciality, String qualification, String hoursday, String position, String religion, int sallary, String dateOfbirth, String gender, String timeIn, String timeOut, Date createdDate) {
        this.fullName = fullName;
        this.mobile = mobile;
        this.emrNo = emrNo;
        this.nationality = nationality;
        this.address = address;
        this.daysservice = daysservice;
        this.cnic = cnic;
        this.email = email;
        this.speciality = speciality;
        this.qualification = qualification;
        this.hoursday = hoursday;
        this.position = position;
        this.religion = religion;
        this.sallary = sallary;
        this.dateOfbirth = dateOfbirth;
        this.gender = gender;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.createdDate = createdDate;
    }

    public Long getMrno() {
        return mrno;
    }

    public void setMrno(Long mrno) {
        this.mrno = mrno;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getEmrNo() {
        return emrNo;
    }

    public void setEmrNo(int emrNo) {
        this.emrNo = emrNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDaysservice() {
        return daysservice;
    }

    public void setDaysservice(String daysservice) {
        this.daysservice = daysservice;
    }

    public int getCnic() {
        return cnic;
    }

    public void setCnic(int cnic) {
        this.cnic = cnic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getHoursday() {
        return hoursday;
    }

    public void setHoursday(String hoursday) {
        this.hoursday = hoursday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public int getSallary() {
        return sallary;
    }

    public void setSallary(int sallary) {
        this.sallary = sallary;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

