package com.example.test.DTO;


import java.util.Date;

public class OpdPackageDTO {

    String packageName;
    String packageFacility;
    Double cashRecieved;
    Long discount;
    Double total;
    Long id;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public OpdPackageDTO(){
    }


    public OpdPackageDTO(String packageName, Double cashRecieved, Long discount, Double total, Long id,String createdBy, String updatedBy, Date createdAt, Date updateAt, String packageFacility) {
        this.packageName = packageName;
        this.packageFacility = packageFacility;
        this.cashRecieved = cashRecieved;
        this.discount = discount;
        this.total = total;
        this.id = id;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Double getCashRecieved() {
        return cashRecieved;
    }

    public void setCashRecieved(Double cashRecieved) {
        this.cashRecieved = cashRecieved;
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

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public String getPackageFacility() {
        return packageFacility;
    }

    public void setPackageFacility(String packageFacility) {
        this.packageFacility = packageFacility;
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

    public void setId(Long id) {
        this.id = id;
    }
}
