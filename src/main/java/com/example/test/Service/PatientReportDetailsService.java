package com.example.test.Service;

import com.example.test.Commons.PatientReport;
import com.example.test.DTO.RestTemplateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PatientReportDetailsService {
    @Autowired
    RestTemplate restTemplate;
    public List<PatientReport> getPatientReportByPatientId(Long patientId){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiLmNvbSIsInNjb3BlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwiaXNzIjoiaHR0cDovL2RldmdsYW4uY29tIiwiaWF0IjoxNTY3Nzg1NTk0LCJleHAiOjE1Njc4MDM1OTR9.gl8rLQsryjrVHex1awxW2ielbhLPegBLJ0xePq1edIM");
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<RestTemplateResponseDTO> response = restTemplate.exchange("http://localhost:8082/api/patientReport/patient/"+patientId, HttpMethod.GET,httpEntity,RestTemplateResponseDTO.class);
        List<PatientReport> patientReports = response.getBody().getBodyList();
        return patientReports;
    }
}
