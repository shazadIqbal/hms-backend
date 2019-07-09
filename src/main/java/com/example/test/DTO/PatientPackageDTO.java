package com.example.test.DTO;

import java.util.Date;

public class PatientPackageDTO {
    String pName;
    String pFacility;
    Date pStartDate;
    Date pEndDate;
    String pSponsor;
    String status;
    Long pPrice;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public PatientPackageDTO() {

    }

    public PatientPackageDTO(String pName, String pFacility, Date pStartDate, Date pEndDate, String pSponsor, String status, Long pPrice, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.pName = pName;
        this.pFacility = pFacility;
        this.pStartDate = pStartDate;
        this.pEndDate = pEndDate;
        this.pSponsor = pSponsor;
        this.status = status;
        this.pPrice = pPrice;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpFacility() {
        return pFacility;
    }

    public void setpFacility(String pFacility) {
        this.pFacility = pFacility;
    }

    public Date getpStartDate() {
        return pStartDate;
    }

    public void setpStartDate(Date pStartDate) {
        this.pStartDate = pStartDate;
    }

    public Date getpEndDate() {
        return pEndDate;
    }

    public void setpEndDate(Date pEndDate) {
        this.pEndDate = pEndDate;
    }

    public String getpSponsor() {
        return pSponsor;
    }

    public void setpSponsor(String pSponsor) {
        this.pSponsor = pSponsor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getpPrice() {
        return pPrice;
    }

    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
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
