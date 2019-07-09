package com.example.test.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PatientPackage")
public class PatientPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String pName;
    String pFacility;
    Date pStartDate;
    Date pEndDate;
    String pSponsor;
    Long pPrice;
    String status;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public PatientPackage() {
    }

    public PatientPackage(String pName, String pFacility, Date pStartDate, Date pEndDate, String pSponsor, Long pPrice, String status, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.pName = pName;
        this.pFacility = pFacility;
        this.pStartDate = pStartDate;
        this.pEndDate = pEndDate;
        this.pSponsor = pSponsor;
        this.pPrice = pPrice;
        this.status = status;
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

    public Long getpPrice() {
        return pPrice;
    }

    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
