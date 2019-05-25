package com.example.test.Service;

import com.example.test.DTO.OPDObservationDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.Model.Doctor;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import java.util.UUID;

@Service
public class OPDObservationService {

    @Autowired
    PatientRepository patientRepository;
    @Value("${transaction.url}")
    public String url;


    @Transient
    private UUID ref ;

    RestTemplate restTemplate = new RestTemplate();

    public String saveOpdObservationToAccounts(OPDObservationDTO data){
        Patient patient = patientRepository.findById(data.getId()).get();
       // patient.setObsRegisteration(true);
        TransactionRestDTO request = new TransactionRestDTO();
        request.setAccountNoUUID(patient.getAccountNo());
        request.setReceivedAmount(data.getCashRecieved());
        request.setTotalAmount(data.getTotal());
        request.setOperationType("OBSERVATION");
        request.setTransactionType("DEBIT");

        request.setDescription(descriptionlist(patient.getName(), data.getDoctors()));

        //refid

        request.setTransactionRefId(ref.randomUUID().toString());

        RestTemplateResponseDTO result = restTemplate.postForObject(url, request, RestTemplateResponseDTO.class);
        if (result.getCode().equalsIgnoreCase("200")){
            return "{\"ADDED SUCCESFULLY\":1}";
        } else {
            return "{\"Some Thing Went Wrong\":1}";
        }
    }

    public String descriptionlist(String patientName, Doctor doctors) {
        String des = "This" + patientName + " avails " + " this "+ doctors.getFullName();
        return des;
    }
}
