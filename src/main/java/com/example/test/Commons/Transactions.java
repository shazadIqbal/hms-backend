package com.example.test.Commons;

import java.util.Date;

public class Transactions {


    private Long id;
    private Date transactionDate;
    private Long receivedAmount;
    private Double totalAmount;
    private String transactionType;
    private String description;
    private String currency;
    private String operationType;
    private Double dues;

    public Transactions(Long id, Date transactionDate, Long receivedAmount, Double totalAmount, String transactionType, String description, String currency, String operationType, Double dues) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.receivedAmount = receivedAmount;
        this.totalAmount = totalAmount;
        this.transactionType = transactionType;
        this.description = description;
        this.currency = currency;
        this.operationType = operationType;
        this.dues = dues;
    }

    public Transactions() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(Long receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Double getDues() {
        return dues;
    }

    public void setDues(Double dues) {
        this.dues = dues;
    }
}
