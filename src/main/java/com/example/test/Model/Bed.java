package com.example.test.Model;

import javax.persistence.*;

@Entity
@Table(name = "Bed")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bedType;
    private Boolean isOccupied;
    public Long price;

    public Bed() {
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Bed(String bedType, Boolean isOccupied, Long price) {
        this.bedType = bedType;
        this.isOccupied = isOccupied;
        this.price = price;
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

    public Boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }
}
