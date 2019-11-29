package com.example.test.Service;

import com.example.test.Commons.PatientReport;
import com.example.test.DTO.RestTemplateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PatientReportDetailsService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${user.token}")
    public String userToken;

    public List<PatientReport> getPatientReportByPatientId(Long patientId){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization",userToken);
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<RestTemplateResponseDTO> response = restTemplate.exchange("http://localhost:8082/api/patientReport/patient/"+patientId, HttpMethod.GET,httpEntity,RestTemplateResponseDTO.class);
        List<PatientReport> patientReports = response.getBody().getBodyList();
        return patientReports;
    }
}
