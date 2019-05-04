package com.example.test.DTO;

public class BedDto {

    private Long id;
    private String bedType;
    private  Boolean isOccupied;
    private Long bedsQuantity;
    public Long price;
    public Long cashRecieved;

    public BedDto() {
    }

    public BedDto(Long id, String bedType, Boolean isOccupied, Long bedsQuantity, Long price,Long cashRecieved) {
        this.id = id;
        this.bedType = bedType;
        this.isOccupied = isOccupied;
        this.bedsQuantity = bedsQuantity;
        this.price = price;
        this.cashRecieved = cashRecieved;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public Long getCashRecieved() {
        return cashRecieved;
    }

    public void setCashRecieved(Long cashRecieved) {
        this.cashRecieved = cashRecieved;
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

    public Long getBedsQuantity() {
        return bedsQuantity;
    }

    public void setBedsQuantity(Long bedsQuantity) {
        this.bedsQuantity = bedsQuantity;
    }
}
