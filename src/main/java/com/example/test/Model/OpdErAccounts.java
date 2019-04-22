package com.example.test.Model;

public class OpdErAccounts {
    Long cashRecieve;
    Long total;
    Long dues;
    Long id;

    public OpdErAccounts(Long cashRecieve, Long total, Long dues,Long id) {
        this.cashRecieve = cashRecieve;
        this.total = total;
        this.dues = dues;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OpdErAccounts() {
    }

    public Long getCashRecieve() {
        return cashRecieve;
    }

    public void setCashRecieve(Long cashRecieve) {
        this.cashRecieve = cashRecieve;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getDues() {
        return dues;
    }

    public void setDues(Long dues) {
        this.dues = dues;
    }
}
