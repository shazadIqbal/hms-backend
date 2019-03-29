package com.example.test.Model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Panel")
public class Panel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String panelName;
    String panelType;
    String  panelStartDate;
    String panelEndDate;
    String[] panelFacility;

    String status;
    Date date;

    public Panel() {
    }

    public Panel(String panelName, String panelType, String panelStartDate, String panelEndDate, String[] panelFacility, String status, Date date) {
        this.panelName = panelName;
        this.panelType = panelType;
        this.panelStartDate = panelStartDate;
        this.panelEndDate = panelEndDate;
        this.panelFacility = panelFacility;
        this.status = status;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public String getPanelType() {
        return panelType;
    }

    public void setPanelType(String panelType) {
        this.panelType = panelType;
    }

    public String getPanelStartDate() {
        return panelStartDate;
    }

    public void setPanelStartDate(String panelStartDate) {
        this.panelStartDate = panelStartDate;
    }

    public String getPanelEndDate() {
        return panelEndDate;
    }

    public void setPanelEndDate(String panelEndDate) {
        this.panelEndDate = panelEndDate;
    }

    public String[] getPanelFacility() {
        return panelFacility;
    }

    public void setPanelFacility(String[] panelFacility) {
        this.panelFacility = panelFacility;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
