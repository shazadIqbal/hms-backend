package com.example.test.Service;

import com.example.test.DTO.OpdConsultancyDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.Model.Doctor;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpdConsultancyService {
    @Autowired
    PatientRepository patientRepository;
    @Value("${transaction.url}")
    public String url;


    RestTemplate restTemplate = new RestTemplate();

    public String saveOpdConsultancyToAccounts(OpdConsultancyDTO data) {
        Patient patient = patientRepository.findById(data.getId()).get();
        TransactionRestDTO response = new TransactionRestDTO();
        response.setAccountNoUUID(patient.getAccountNo());
        response.setReceivedAmount(data.getCashRecieved());
        response.setTotalAmount(data.getTotal());
        response.setOperationType("CONSULTANCY");
        response.setTransactionType("DEBIT");
        response.setDescription(descriptionlist(patient.getName(), data.getDoctors()));
        RestTemplateResponseDTO result = restTemplate.postForObject(url, response, RestTemplateResponseDTO.class);
        if (result.getCode().equalsIgnoreCase("200")) {

            return "{\"ADDED SUCCESFULLY\":1}";
        } else {
            return "{\"Some Thing Went Wrong\":1}";
        }


    }

    public String descriptionlist(String patientName, Doctor doctors) {

       // System.out.println(facilities.toString());


        String des = "This"+patientName + " avails " + " this "+ doctors.getFullName();
        return des;




    }
}