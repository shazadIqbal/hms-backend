package com.example.test.DTO;

public class PanelDTO {
    String panelName;
    String panelType;
    String  panelStartDate;
    String panelEndDate;
    String[] panelFacility;

    public PanelDTO() {
    }

    public PanelDTO(String panelName, String panelType, String panelStartDate, String panelEndDate, String[] panelFacility) {
        this.panelName = panelName;
        this.panelType = panelType;
        this.panelStartDate = panelStartDate;
        this.panelEndDate = panelEndDate;
        this.panelFacility = panelFacility;
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
}
