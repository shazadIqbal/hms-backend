package com.example.test.DTO;

import java.util.Date;

public class AppoinmentDTO {

    private Long id;
    private String selectDoctor;
    private Date appoinmentDate;
    private String time;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public AppoinmentDTO() {

    }

    public AppoinmentDTO(Long id, String selectDoctor, Date appoinmentDate, String time, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.id = id;
        this.selectDoctor = selectDoctor;
        this.appoinmentDate = appoinmentDate;
        this.time = time;
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
