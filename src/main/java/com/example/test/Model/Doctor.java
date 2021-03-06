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
    String mobile;
    String  emrNo;
    String nationality;
    String address;
    String daysservice;
    String cnic;
    String email;
    String speciality;
    String qualification;
    String hoursday;
    String position;
    String religion;
    Integer  sallary;
    String dateOfbirth;
    Long fees;
    String gender;
    String timeIn;
    String timeOut;
    Date createdDate;
    String status;
    private String accountNo;
    private Integer share;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public Doctor() {
    }

    public Doctor(String fullName, String mobile, String emrNo, String nationality, String status, String address, String daysservice, String cnic, String email, String speciality, String qualification, String hoursday, String position, String religion, Integer sallary, String dateOfbirth, Long fees, String gender, String timeIn, String timeOut, Date createdDate, String accountNo, Integer share, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
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
        this.fees = fees;
        this.gender = gender;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.createdDate = createdDate;
        this.accountNo = accountNo;
        this.status = status;
        this.share = share;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmrNo() {
        return emrNo;
    }

    public void setEmrNo(String emrNo) {
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

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
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

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

