package com.example.test.DTO;

import java.util.Date;

public class LabtestDTO {

    String category;
    String name;
    String price;
    String details;
    String status;
    Date createdDate;

    public LabtestDTO() {
    }
    public LabtestDTO(String category, String name, String price, String details) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.details = details;
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
}
