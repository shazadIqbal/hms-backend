package com.example.test.Commons;

import java.util.Date;

public class Transactions {


    private Long id;
    private Date transactionDate;
    private Double receivedAmount;
    private Double totalAmount;
    private String transactionType;
    private String description;
    private String currency;
    private String operationType;
    private Double dues;
    private String transactionRefId;

    public Transactions(String transactionRefId,Long id, Date transactionDate, Double receivedAmount, Double totalAmount, String transactionType, String description, String currency, String operationType, Double dues) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.receivedAmount = receivedAmount;
        this.totalAmount = totalAmount;
        this.transactionType = transactionType;
        this.description = description;
        this.currency = currency;
        this.operationType = operationType;
        this.dues = dues;
        this.transactionRefId=transactionRefId;
    }

    public Transactions() {
    }

    public String getTransactionRefId() {
        return transactionRefId;
    }

    public void setTransactionRefId(String transactionRefId) {
        this.transactionRefId = transactionRefId;
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

    public Double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(Double receivedAmount) {
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
