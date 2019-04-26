package com.example.test.Model;

import javax.persistence.Entity;
import javax.persistence.Table;



public class OpdEr {
    String[] facilities;
    Long discount;
    Long id;


    public OpdEr() {
    }

    public OpdEr(String[] facilities, Long discount,Long id) {
        this.facilities = facilities;
        this.discount = discount;
        this.id=id;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }
}
