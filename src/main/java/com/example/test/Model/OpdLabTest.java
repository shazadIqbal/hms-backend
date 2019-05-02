package com.example.test.Model;

public class OpdLabTest {
    String[] labTests;
    Long discount;
    Long id;

    public OpdLabTest(String[] labTests, Long discount, Long id) {
        this.labTests = labTests;
        this.discount = discount;
        this.id = id;
    }

    public OpdLabTest() {
    }

    public String[] getLabTests() {
        return labTests;
    }

    public void setLabTests(String[] labTests) {
        this.labTests = labTests;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
