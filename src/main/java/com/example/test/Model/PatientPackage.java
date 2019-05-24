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

    public PatientPackage() {

    }

    public PatientPackage(String pName, String pFacility, Date pStartDate, Date pEndDate, String pSponsor, String status, Long pPrice) {
        this.pName = pName;
        this.pFacility = pFacility;
        this.pStartDate = pStartDate;
        this.pEndDate = pEndDate;
        this.pSponsor = pSponsor;
        this.status = status;
        this.pPrice = pPrice;
    }

    public Long getpPrice() {
        return pPrice;
    }

    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
