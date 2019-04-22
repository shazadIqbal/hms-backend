package com.example.test.DTO;

public class OpdErDTO {
    String[] facilities;
    Double cashRecieve;
    Long discount;
    Double total;
    Long id;
    double dues;

    public OpdErDTO() {
    }

    public OpdErDTO(String[] facilities, Double cashRecieve, Long discount, Double total, Long id, double dues) {
        this.facilities = facilities;
        this.cashRecieve = cashRecieve;
        this.discount = discount;
        this.total = total;
        this.id = id;
        this.dues = dues;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }

    public Double getCashRecieve() {
        return cashRecieve;
    }

    public void setCashRecieve(Double cashRecieve) {
        this.cashRecieve = cashRecieve;
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

    public void setId(Long id) {
        this.id = id;
    }

    public double getDues() {
        return dues;
    }

    public void setDues(double dues) {
        this.dues = dues;
    }
}