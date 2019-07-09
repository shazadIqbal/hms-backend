package com.example.test.Model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id", scope = Facility.class)
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String status;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    @ManyToMany(mappedBy = "facilities")
    //@JsonIgnoreProperties("facilities")
    @JsonBackReference
   // @JsonIgnore
    private List<Er> erServices;

    public Facility() {
    }

    public Facility(String name, Integer price, String status, String createdBy, String updatedBy, Date createdAt, Date updateAt, List<Er> erServices) {
        this.name = name;
        this.price = price;
        this.status = status;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
        this.erServices = erServices;
    }
    //    @Override
//    public
//    boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Facility facility = (Facility) o;
//        return Objects.equals(id, facility.id) &&
//                Objects.equals(name, facility.name) &&
//                Objects.equals(price, facility.price) &&
//                Objects.equals(status, facility.status) &&
//                Objects.equals(erServices, facility.erServices);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, name, price, status, erServices);
//    }

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

    public List<Er> getErServices() {
        return erServices;
    }

    public void setErServices(List<Er> erServices) {
        this.erServices = erServices;
    }
}
