package com.example.test.DTO;

public class AccountRestDTO {
    private String id;
    private String name;
    private String gender;
    private String accountType;

    public AccountRestDTO(String id, String name, String gender, String accountType) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.accountType = accountType;

    }

    public AccountRestDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}


