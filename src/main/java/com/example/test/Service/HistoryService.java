package com.example.test.Service;


import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.History;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;



@Service
public class HistoryService {

    @Value("${transaction.url}")
    public String url;



    @Autowired
    PatientRepository patientRepository;

    RestTemplate restTemplate = new RestTemplate();

    public RestTemplateResponseDTO getHistory(Long id) {

        Optional<Patient> p = patientRepository.findById(id);

        Patient patient = p.get();


        if (p.isPresent()) {

            String accountId = patient.getAccountNo();


//        aa4f062d-a115-42aa-bdcd-78e324426137

            RestTemplateResponseDTO response = restTemplate.getForObject(url + accountId, RestTemplateResponseDTO.class);

            

        return response;

        }

        else
        {
            return new RestTemplateResponseDTO();
        }

    }
}
