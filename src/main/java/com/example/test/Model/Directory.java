package com.example.test.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Directory")
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String number;
    String address;
    String erNo;
    String status;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public Directory() {
    }

    public Directory(String name, String number, String address, String erNo, String status, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.erNo = erNo;
        this.status = status;
        this.CreatedBy = createdBy;
        this.UpdatedBy = updatedBy;
        this.CreatedAt = createdAt;
        this.UpdateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getErNo() {
        return erNo;
    }

    public void setErNo(String erNo) {
        this.erNo = erNo;
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
