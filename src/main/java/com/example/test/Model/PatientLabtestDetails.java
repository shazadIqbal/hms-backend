package com.example.test.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PatientLabtestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labtestName;
    private String status;
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patientLab;

    public PatientLabtestDetails() {
    }
    public String getLabtestName() {
        return labtestName;
    }

    public void setLabtestName(String labtestName) {
        this.labtestName = labtestName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Patient getPatient() {
        return patientLab;
    }

    public void setPatient(Patient patient) {
        this.patientLab = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatientLab() {
        return patientLab;
    }

    public void setPatientLab(Patient patientLab) {
        this.patientLab = patientLab;
    }
}
