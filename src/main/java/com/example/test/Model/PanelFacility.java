package com.example.test.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PanelFacility")
public class PanelFacility {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String facilityName;
    Date date;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PanelFacility() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PanelFacility(String facilityName, Date date) {

        this.facilityName = facilityName;
        this.date = date;
    }
}
