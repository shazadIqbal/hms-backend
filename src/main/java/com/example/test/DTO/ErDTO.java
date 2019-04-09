package com.example.test.DTO;

import com.example.test.Model.Facility;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ErDTO {
    private String name;
    private String resources;
    private Integer price;
    private Integer extraCharges;
    private Integer total;
    private String status;
    private List<Facility> facilities;

    public ErDTO() {
    }

//       public ErDTO(String name, String resources, Integer price, Integer extraCharges, Integer total,String status) {
//        this.name = name;
//        this.resources = resources;
//        this.price = price;
//        this.extraCharges = extraCharges;
//        this.total = total;
//    }
//
//    public ErDTO(String name, String resources, Integer price, Integer extraCharges, Integer total,String status, List<Facility> facilities) {
//        this.name = name;
//        this.resources = resources;
//        this.price = price;
//        this.extraCharges = extraCharges;
//        this.total = total;
//        this.facilities = facilities;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getExtraCharges() {
        return extraCharges;
    }

    public void setExtraCharges(Integer extraCharges) {
        this.extraCharges = extraCharges;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ErDTO erDTO = (ErDTO) o;
//        return Objects.equals(name, erDTO.name) &&
//                Objects.equals(resources, erDTO.resources) &&
//                Objects.equals(price, erDTO.price) &&
//                Objects.equals(extraCharges, erDTO.extraCharges) &&
//                Objects.equals(total, erDTO.total) &&
//                Objects.equals(status, erDTO.status) &&
//                Objects.equals(facilities, erDTO.facilities);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name, resources, price, extraCharges, total, status, facilities);
//    }
}
