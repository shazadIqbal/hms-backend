package com.example.test.DTO;

public class OpdLabTestDTO {
    Long id;
    String[] labTests;
    Double cashRecieve;
    Long discount;
    Double total;

    public OpdLabTestDTO() {
    }

    public String[] getLabTests() {
        return labTests;
    }

    public void setLabTests(String[] labTests) {
        this.labTests = labTests;
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
}
