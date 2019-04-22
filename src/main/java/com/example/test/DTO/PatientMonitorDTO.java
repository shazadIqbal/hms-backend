package com.example.test.DTO;

import java.util.Date;

public class PatientMonitorDTO {

    Long id;
    String name;
    String number;
    Date date;

    public PatientMonitorDTO(Long id, String name, String number,Date date) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.date=date;
    }

    public PatientMonitorDTO() {

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
