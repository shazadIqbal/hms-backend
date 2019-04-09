package com.example.test.DTO;

import java.util.Date;

public class AppoinmentDTO {

    private Long id;
    private String selectDoctor;
    private Date appoinmentDate;
    private String time;





    public AppoinmentDTO() {
    }

    public AppoinmentDTO(Long id, String selectDoctor, String status, Date appoinmentDate, String time) {
        this.id = id;
        this.selectDoctor = selectDoctor;
        this.appoinmentDate = appoinmentDate;
        this.time = time;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
