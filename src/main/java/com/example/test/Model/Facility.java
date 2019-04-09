package com.example.test.Model;


import javax.persistence.*;
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

    @ManyToMany(mappedBy = "facilities")
    //@JsonIgnoreProperties("facilities")
    @JsonBackReference
   // @JsonIgnore
    private List<Er> erServices;

    public Facility() {
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
}
