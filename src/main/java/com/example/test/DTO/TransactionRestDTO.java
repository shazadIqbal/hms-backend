package com.example.test.DTO;

public class TransactionRestDTO {

    Double   totalAmount;
    String   accountNoUUID;
    Double   receivedAmount;
    String   description;
    String   operationType;
    String   transactionType;

    public TransactionRestDTO() {
    }

    public TransactionRestDTO(Double totalAmount, String   accountNoUUID, Double receivedAmount, String description, String operationType, String transactionType) {
        this.totalAmount = totalAmount;
        this.accountNoUUID = accountNoUUID;
        this.receivedAmount = receivedAmount;
        this.description = description;
        this.operationType = operationType;
        this.transactionType = transactionType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAccountNoUUID() {
        return accountNoUUID;
    }

    public void setAccountNoUUID(String accountNoUUID) {
        this.accountNoUUID = accountNoUUID;
    }

    public Double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(Double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
