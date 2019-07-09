package com.example.test.Model;

import java.util.Date;

public class OpdErAccounts {
    Long cashRecieve;
    Long total;
    Long dues;
    Long id;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public OpdErAccounts() {
    }

    public OpdErAccounts(Long cashRecieve, Long total, Long dues, Long id, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.cashRecieve = cashRecieve;
        this.total = total;
        this.dues = dues;
        this.id = id;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;

    }

    public Long getCashRecieve() {
        return cashRecieve;
    }

    public void setCashRecieve(Long cashRecieve) {
        this.cashRecieve = cashRecieve;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getDues() {
        return dues;
    }

    public void setDues(Long dues) {
        this.dues = dues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
