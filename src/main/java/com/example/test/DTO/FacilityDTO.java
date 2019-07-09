package com.example.test.DTO;

import com.example.test.Model.Er;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FacilityDTO {
    private String name;
    private Integer price;
    private String status;
    private List<Er> erServices;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public FacilityDTO() {
    }

    public FacilityDTO(String name, Integer price, String status, List<Er> erServices, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.erServices = erServices;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Er> getErServices() {
        return erServices;
    }

    public void setErServices(List<Er> erServices) {
        this.erServices = erServices;
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
    //    public FacilityDTO(String name, Integer price,String status) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public FacilityDTO(String name, Integer price,String status, Set<Er> erServices) {
//        this.name = name;
//        this.price = price;
//        this.erServices = erServices;
//    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FacilityDTO that = (FacilityDTO) o;
//        return Objects.equals(name, that.name) &&
//                Objects.equals(price, that.price) &&
//                Objects.equals(status, that.status) &&
//                Objects.equals(erServices, that.erServices);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name, price, status, erServices);
//    }
}
