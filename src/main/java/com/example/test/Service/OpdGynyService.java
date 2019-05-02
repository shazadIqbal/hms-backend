package com.example.test.Service;

import com.example.test.DTO.OpdGynyDTO;
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
public class OpdGynyService {
    @Autowired
    PatientRepository patientRepository;

    @Value("${transaction.url}")
    public String url;

    RestTemplate restTemplate = new RestTemplate();


    public String saveOpdGynyToAccounts(OpdGynyDTO data){
        Patient patient = patientRepository.findById(data.getId()).get();
        TransactionRestDTO request = new TransactionRestDTO();

        request.setAccountNoUUID(patient.getAccountNo());
        request.setReceivedAmount(data.getCashRecieved());
        request.setTotalAmount(data.getTotal());
        request.setOperationType("GYNY");
        request.setTransactionType("DEBIT");
        request.setDescription(descriptionList(patient.getName(), data.getDoctors()));
        RestTemplateResponseDTO response = restTemplate.postForObject(url, request, RestTemplateResponseDTO.class);

        if (response.getCode().equalsIgnoreCase("200")) {

            return "{\"ADDED SUCCESFULLY\":1}";
        } else {
            return "{\"Some Thing Went Wrong\":1}";
        }



    }


    public String descriptionList(String patientName, Doctor doctors){

        String des = "This"+patientName + " avails " + " this "+ doctors.getFullName();
        return des;

    }
  //  Patient patient = patientRepository.findById()
}
