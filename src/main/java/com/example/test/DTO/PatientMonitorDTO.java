package com.example.test.DTO;

import java.util.Date;

public class PatientMonitorDTO {

    Long id;
    String name;
    String number;
    Date date;
    Long er;
    Long opd;
    Long total;
    Long lab;
    Long dues;


    public PatientMonitorDTO(Long id, String name, String number, Date date, Long er, Long opd, Long total, Long lab, Long dues) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.date = date;
        this.er = er;
        this.opd = opd;
        this.total = total;
        this.lab = lab;
        this.dues = dues;
    }

    public PatientMonitorDTO() {

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
