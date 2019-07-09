package com.example.test.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Appoinment")
public class Appoinment {

    @Id
    private Long id;
    private String status;
    private String selectDoctor;
    private Date appoinmentDate;
    private String time;
    private String patientName;
    private String phoneNo;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public Appoinment() {
    }

    public Appoinment(Long id, String status, String selectDoctor, Date appoinmentDate, String time, String patientName, String phoneNo, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.id = id;
        this.status = status;
        this.selectDoctor = selectDoctor;
        this.appoinmentDate = appoinmentDate;
        this.time = time;
        this.patientName = patientName;
        this.phoneNo = phoneNo;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSelectDoctor() {
        return selectDoctor;
    }

    public void setSelectDoctor(String selectDoctor) {
        this.selectDoctor = selectDoctor;
    }

    public Date getAppoinmentDate() {
        return appoinmentDate;
    }

    public void setAppoinmentDate(Date appoinmentDate) {
        this.appoinmentDate = appoinmentDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

