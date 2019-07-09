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
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;
    String status;
    Date date;

    public Panel() {
    }

    public Panel(String panelName, String panelType, String panelStartDate, String panelEndDate, String[] panelFacility, String createdBy, String updatedBy, Date createdAt, Date updateAt, String status, Date date) {
        this.panelName = panelName;
        this.panelType = panelType;
        this.panelStartDate = panelStartDate;
        this.panelEndDate = panelEndDate;
        this.panelFacility = panelFacility;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
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
