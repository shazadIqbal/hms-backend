package com.example.test.DTO;

import java.util.Date;

public class GetReportsByTimeDTO {

    private String from;
    private String till;
    private String role;

    public GetReportsByTimeDTO()
    {

    }

    public GetReportsByTimeDTO(String from, String till, String role) {
        this.from = from;
        this.till = till;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
    }
}

