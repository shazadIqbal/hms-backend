package com.example.test.DTO;

import java.util.Date;
import java.util.List;

public class RestTemplateResponseDTO<T> {
    private String code;
    private String message;
    private T body;
    private List<T> bodyList;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedAt;
    private Date UpdateAt;

    public RestTemplateResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestTemplateResponseDTO() {
    }

    public RestTemplateResponseDTO(String code, String message, T body, List<T> bodyList, String createdBy, String updatedBy, Date createdAt, Date updateAt) {
        this.code = code;
        this.message = message;
        this.body = body;
        this.bodyList = bodyList;
        CreatedBy = createdBy;
        UpdatedBy = updatedBy;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
    }

    public RestTemplateResponseDTO(String code, String message, List<T> bodyList) {
        this.code = code;
        this.message = message;
        this.bodyList = bodyList;
    }

    public RestTemplateResponseDTO(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public List<T> getBodyList() {
        return bodyList;
    }

    public void setBodyList(List<T> bodyList) {
        this.bodyList = bodyList;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date updateAt) {
        UpdateAt = updateAt;
    }
}

