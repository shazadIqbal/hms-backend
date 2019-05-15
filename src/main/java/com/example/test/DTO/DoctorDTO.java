package com.example.test.DTO;

import java.util.Date;

public class DoctorDTO {
    Long mrNo;
    String  fullName;
    String mobile;
  Integer  emrNo;
   String nationality;
    String address;
    String daysservice;
   Integer cnic;
   Long fees;
    String email;
    String speciality;
    String qualification;
    String hoursday;
    String position;
    String religion;
    Integer  sallary;
    String dateOfbirth;
    String gender;
    String timeIn;
    String timeOut;
    Date createdDate;
    private String accountNo;
    private Integer share;
    public DoctorDTO(Long mrNo,Long fees, String fullName, String mobile, Integer emrNo, String nationality, String address, String daysservice, Integer cnic, String email, String speciality, String qualification, String hoursday, String position, String religion, Integer sallary, String dateOfbirth, String gender, String timeIn, String timeOut, String accountNo, Integer share) {
        this.mrNo = mrNo;
        this.fullName = fullName;
        this.mobile = mobile;
        this.emrNo = emrNo;
        this.fees=fees;
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
        this.accountNo = accountNo;
    }

    public DoctorDTO() {
    }

    public Long getMrNo() {
        return mrNo;
    }

    public void setMrNo(Long mrNo) {
        this.mrNo = mrNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getEmrNo() {
        return emrNo;
    }

    public void setEmrNo(Integer emrNo) {
        this.emrNo = emrNo;
    }

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
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

    public Integer getCnic() {
        return cnic;
    }

    public void setCnic(Integer cnic) {
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

    public Integer getSallary() {
        return sallary;
    }

    public void setSallary(Integer sallary) {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }
}