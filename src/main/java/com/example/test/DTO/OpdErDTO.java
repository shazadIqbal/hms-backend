package com.example.test.DTO;

import java.util.Date;

public class OpdErDTO {
    String[] facilities;
    Double cashRecieve;
    Long discount;
    Double total;
    Long id;
    double dues;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public OpdErDTO() {
    }

    public OpdErDTO(String[] facilities, Double cashRecieve, Long discount, Double total, Long id, double dues, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.facilities = facilities;
        this.cashRecieve = cashRecieve;
        this.discount = discount;
        this.total = total;
        this.id = id;
        this.dues = dues;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }

    public Double getCashRecieve() {
        return cashRecieve;
    }

    public void setCashRecieve(Double cashRecieve) {
        this.cashRecieve = cashRecieve;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDues() {
        return dues;
    }

    public void setDues(double dues) {
        this.dues = dues;
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