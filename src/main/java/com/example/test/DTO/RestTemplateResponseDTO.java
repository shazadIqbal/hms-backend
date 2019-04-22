package com.example.test.DTO;

public class RestTemplateResponseDTO {
    private String code;
    private String message;

    public RestTemplateResponseDTO() {
    }

    public RestTemplateResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
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
}
