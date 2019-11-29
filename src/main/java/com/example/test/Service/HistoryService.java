package com.example.test.Service;


import com.example.test.Commons.Transactions;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Bed;
import com.example.test.Model.History;
import com.example.test.Model.Patient;
import com.example.test.Repository.BedRepository;
import com.example.test.Repository.HistoryRepository;
import com.example.test.Repository.PatientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class HistoryService {

    @Value("${transaction.url}")
    public String url;



    @Autowired
    PatientRepository patientRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    BedRepository bedRepository;

    @Autowired
    RestTemplate restTemplate;


    public String addPatientHistory(Long id) {

        Optional<Patient> p = patientRepository.findById(id);
        Patient patient = p.get();
        Optional<Bed> bed = bedRepository.findById(patient.getBedId());
        Bed bedNew = bed.get();
        bedNew.setOccupied(Boolean.FALSE);
        bedRepository.save(bedNew);
        patient.setDischarge(Boolean.TRUE);
        patient.setBedId(-1L);

        if (p.isPresent()) {

            String accountId = patient.getAccountNo();


//        aa4f062d-a115-42aa-bdcd-78e324426137

            RestTemplateResponseDTO response = restTemplate.getForObject(url + accountId, RestTemplateResponseDTO.class);


            ObjectMapper mapper = new ObjectMapper();
            List<Transactions> transactionList = mapper.convertValue(
                    response.getBodyList(),
                    new TypeReference<List<Transactions>>() {
                    }
            );


            for(Transactions a : transactionList)
            {
                History history=new History();
                history.setCurrency(a.getCurrency());
                history.setTotalAmount(a.getTotalAmount());
                history.setTransactionDate(a.getTransactionDate());
                history.setTransactionType(a.getTransactionType());
                history.setOperationType(a.getOperationType());
                history.setReceivedAmount(a.getReceivedAmount());
                history.setDues(a.getDues());
                history.setPatient(patient);
                history.setCurrency(a.getCurrency());
                history.setDescription(a.getDescription());
                historyRepository.save(history);
            }



            return "{\"Patient Discharge Successful\":1}";
        }


        return "{\"An Error occured while discharging\":1}";


    }

    public List<History> getPatientHistory(Long id)
    {
        Optional<Patient> response = patientRepository.findById(id);
        Patient patient = response.get();
        if(response.isPresent()){

            List<History> histories=historyRepository.findByPatientId(id);

            return  histories;
        }
        return  new ArrayList<>();
    }
}
