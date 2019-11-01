package com.example.test.DTO;

import java.util.Date;

public class PatientMonitorDTO {

    private Long id;
    private String name;
    private String number;
    private Date date;
    private Long er;
    private Long opd;
    private Long total;
    private Long lab;
    private Long patientPackage;
    private Long dues;

    private Boolean gynAndObsRegistration;
    private String husbandOfAndFatherOf;
    private Date registrationDate;
    private Boolean discharge;
    private Long bedId;

    Long admit;
    String admitLabel;
    Long gyne;
    Long obs;

    public PatientMonitorDTO() {
    }

    public PatientMonitorDTO(Long id, String name, String number, Date date, Long er, Long opd, Long total, Long lab, Long patientPackage, Long dues, Boolean gynAndObsRegistration, String husbandOfAndFatherOf, Date registrationDate, Long admit, String admitLabel, Long gyne, Long obs) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.date = date;
        this.er = er;
        this.opd = opd;
        this.total = total;
        this.lab = lab;
        this.patientPackage = patientPackage;
        this.dues = dues;
        this.gynAndObsRegistration = gynAndObsRegistration;
        this.husbandOfAndFatherOf = husbandOfAndFatherOf;
        this.registrationDate = registrationDate;
        this.admit = admit;
        this.admitLabel = admitLabel;
        this.gyne = gyne;
        this.obs = obs;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getEr() {
        return er;
    }

    public void setEr(Long er) {
        this.er = er;
    }

    public Long getOpd() {
        return opd;
    }

    public void setOpd(Long opd) {
        this.opd = opd;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getLab() {
        return lab;
    }

    public void setLab(Long lab) {
        this.lab = lab;
    }

    public Long getDues() {
        return dues;
    }

    public void setDues(Long dues) {
        this.dues = dues;
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


    public Long getAdmit() {
        return admit;
    }

    public void setAdmit(Long admit) {
        this.admit = admit;
    }

    public String getAdmitLabel() {
        return admitLabel;
    }

    public void setAdmitLabel(String admitLabel) {
        this.admitLabel = admitLabel;
    }

    public Long getGyne() {
        return gyne;
    }

    public void setGyne(Long gyne) {
        this.gyne = gyne;
    }

    public Long getObs() {
        return obs;
    }

    public void setObs(Long obs) {
        this.obs = obs;
    }

    public Long getPatientPackage() {
        return patientPackage;
    }

    public void setPatientPackage(Long patientPackage) {
        this.patientPackage = patientPackage;
    }
}

