package com.example.test.DTO;

import java.util.Date;

public class PanelDTO {
    String panelName;
    String panelType;
    String  panelStartDate;
    String panelEndDate;
    String[] panelFacility;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public PanelDTO() {
    }

    public PanelDTO(String panelName, String panelType, String panelStartDate, String panelEndDate, String[] panelFacility, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.panelName = panelName;
        this.panelType = panelType;
        this.panelStartDate = panelStartDate;
        this.panelEndDate = panelEndDate;
        this.panelFacility = panelFacility;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
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
}
