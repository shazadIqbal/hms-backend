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

    public Appoinment() {
    }

    public Appoinment(String phoneNo,String patientName,Long id, String status, String selectDoctor, Date appoinmentDate, String time) {
        this.id = id;
        this.status = status;
        this.selectDoctor = selectDoctor;
        this.appoinmentDate = appoinmentDate;
        this.time = time;
        this.patientName=patientName;
        this.phoneNo=phoneNo;
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
}
