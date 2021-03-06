package com.example.test.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "labtest")
public class Labtest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String category;
    String name;
    String price;
    String details;
    String status;
    Date createdDate;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public Labtest() {
    }

    public Labtest(String category, String name, String price, String details, String status, Date createdDate, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.details = details;
        this.status = status;
        this.createdDate = createdDate;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
