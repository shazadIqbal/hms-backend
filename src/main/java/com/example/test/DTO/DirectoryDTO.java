package com.example.test.DTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class DirectoryDTO {

    String name;
    String number;
    String address;
    String erNo;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public DirectoryDTO(String name, String number, String address, String erNo, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.erNo = erNo;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public DirectoryDTO() {

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
