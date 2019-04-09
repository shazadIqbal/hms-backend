package com.example.test.DTO;

import com.example.test.Model.Er;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FacilityDTO {
    private String name;
    private Integer price;
    private String status;
    private List<Er> erServices;

    public FacilityDTO() {
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

    public List<Er> getErServices() {
        return erServices;
    }

    public void setErServices(List<Er> erServices) {
        this.erServices = erServices;
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
