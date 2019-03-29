package com.example.test.DTO;

import java.util.Date;

public class LabtestCategoryDTO {

    Long id;
    String category;

    String status;
    Date createdDate;


    public LabtestCategoryDTO() {

    }

    public LabtestCategoryDTO(String category, Long id, String status) {
        this.category = category;
        this.id = id;
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
