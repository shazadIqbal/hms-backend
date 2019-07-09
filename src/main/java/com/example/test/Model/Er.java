package com.example.test.Model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.swing.text.View;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "@id", scope = Facility.class)
public class Er {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String resources;
    private Integer price;
    private Integer extraCharges;
    private Integer total;
    private String status;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;



    @ManyToMany
    @JoinTable(name = "er_facility", joinColumns = @JoinColumn(name = "er_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "facility_id", referencedColumnName = "id"))
    //@JsonIgnoreProperties("erServices")
    //@JsonIgnore
    //@JsonView(View.DetailView.class)
    private List<Facility> facilities;

    public Er() {
    }

    public Er(String name, String resources, Integer price, Integer extraCharges, Integer total, String status, String createdBy, String updatedBy, Date createdAt, Date updateAt, List<Facility> facilities) {
        this.name = name;
        this.resources = resources;
        this.price = price;
        this.extraCharges = extraCharges;
        this.total = total;
        this.status = status;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
        this.facilities = facilities;
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

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Er er = (Er) o;
//        return Objects.equals(id, er.id) &&
//                Objects.equals(name, er.name) &&
//                Objects.equals(resources, er.resources) &&
//                Objects.equals(price, er.price) &&
//                Objects.equals(extraCharges, er.extraCharges) &&
//                Objects.equals(total, er.total) &&
//                Objects.equals(status, er.status) &&
//                Objects.equals(facilities, er.facilities);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, name, resources, price, extraCharges, total, status, facilities);
//    }
}
