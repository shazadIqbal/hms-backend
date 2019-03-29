package com.example.test.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "labtestcat")
public class Labtestcategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String category;
    String status;
    Date createdDate;

    public Labtestcategory() {
    }

    public Labtestcategory(String category, String status, Date createdDate) {
        this.category = category;
        this.status = status;
        this.createdDate = createdDate;
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
