package com.example.test.DTO;

import java.util.Date;

public class BedDto {

    private Long id;
    private String bedType;
    private  Boolean isOccupied;
    private Long bedsQuantity;
    public Long price;
    public Long cashRecieved;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public BedDto() {
    }

    public BedDto(Long id, String bedType, Boolean isOccupied, Long bedsQuantity, Long price, Long cashRecieved, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.id = id;
        this.bedType = bedType;
        this.isOccupied = isOccupied;
        this.bedsQuantity = bedsQuantity;
        this.price = price;
        this.cashRecieved = cashRecieved;
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

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public Long getBedsQuantity() {
        return bedsQuantity;
    }

    public void setBedsQuantity(Long bedsQuantity) {
        this.bedsQuantity = bedsQuantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCashRecieved() {
        return cashRecieved;
    }

    public void setCashRecieved(Long cashRecieved) {
        this.cashRecieved = cashRecieved;
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

