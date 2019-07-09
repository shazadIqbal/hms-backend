package com.example.test.DTO;

import java.util.Date;

public class OpdLabTestDTO {
    Long id;
    String[] labTests;
    Double cashRecieve;
    Long discount;
    Double total;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public OpdLabTestDTO() {
    }

    public OpdLabTestDTO(Long id, String[] labTests, Double cashRecieve, Long discount, Double total, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.id = id;
        this.labTests = labTests;
        this.cashRecieve = cashRecieve;
        this.discount = discount;
        this.total = total;
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

    public String[] getLabTests() {
        return labTests;
    }

    public void setLabTests(String[] labTests) {
        this.labTests = labTests;
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
