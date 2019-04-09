package com.example.test.Model;

import javax.persistence.*;

@Entity
@Table(name="Directory")
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    String name;
    String number;
    String address;
    Integer erNo;
    String status;


    public Directory(String name, String number, String address, Integer erNo,String status) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.erNo = erNo;
        this.status=status;
    }

    public Directory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
