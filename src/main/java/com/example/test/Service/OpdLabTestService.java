package com.example.test.Service;

import com.example.test.DTO.OpdLabTestDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import java.util.UUID;

@Service
public class OpdLabTestService {
    @Autowired
    PatientRepository patientRepository;

    @Value("${transaction.url}")
    public  String  url;

    @Transient
    private UUID ref ;

    RestTemplate restTemplate = new RestTemplate();

    public String saveToAccounts(OpdLabTestDTO data) {
        Patient patient = patientRepository.findById(data.getId()).get();
        TransactionRestDTO response = new TransactionRestDTO();
        response.setAccountNoUUID(patient.getAccountNo());
        response.setOperationType("LABTEST");
        response.setTransactionType("DEBIT");
        response.setReceivedAmount(data.getCashRecieve());
        response.setTotalAmount(data.getTotal());
        response.setDescription(descriptionlist(patient.getName(), data.getLabTests()));

        //refid


        response.setTransactionRefId(ref.randomUUID().toString());

        RestTemplateResponseDTO result = restTemplate.postForObject(url, response, RestTemplateResponseDTO.class);
        if (result.getCode().equalsIgnoreCase("200")) {

            return "{\"ADDED SUCCESFULLY\":1}";
        } else {
            return "{\"Some Thing Went Wrong\":1}";
        }



    }

    public String descriptionlist(String patientName, String[] labTest) {

        System.out.println(labTest.toString());
        StringBuilder f = new StringBuilder();
        for (int i = 0; i < labTest.length; i++) {
            f.append(labTest[i]);
            if (i < labTest.length - 1) {
                f.append(" ,");
            }

        }

        String des = patientName + "avails " + f;
        return des;

    }
}