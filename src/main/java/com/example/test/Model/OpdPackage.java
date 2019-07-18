package com.example.test.Model;

import java.util.Date;

public class OpdPackage {

    String packageName;
    String packageFacility;
    Long discount;
    Long id;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public OpdPackage() {
    }

    public OpdPackage(String packageName, Long discount, Long id, String createdBy, String updatedBy, Date createdAt, Date updateAt,String packageFacility) {
        this.packageName = packageName;
        this.packageFacility = packageFacility;
        this.discount = discount;
        this.id = id;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public String getPackageFacility() {
        return packageFacility;
    }

    public void setPackageFacility(String packageFacility) {
        this.packageFacility = packageFacility;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
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
