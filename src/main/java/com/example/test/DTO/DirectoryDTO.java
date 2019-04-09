package com.example.test.DTO;

import javax.persistence.criteria.CriteriaBuilder;

public class DirectoryDTO {

    String name;
    String number;
    String address;
    Integer erNo;

    public DirectoryDTO(String name, String number, String address, Integer erNo) {

        this.name = name;
        this.number = number;
        this.address = address;
        this.erNo = erNo;
    }
    public DirectoryDTO() {


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getErNo() {
        return erNo;
    }

    public void setErNo(Integer erNo) {
        this.erNo = erNo;
    }
}
