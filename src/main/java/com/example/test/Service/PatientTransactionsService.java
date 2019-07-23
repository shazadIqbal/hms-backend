package com.example.test.Service;

import com.example.test.Commons.Transactions;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientTransactionsService {

    @Value("${transaction.url}")
    public String url;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Transactions> getPatientTransactions(Long id){
        Optional<Patient> response = patientRepository.findById(id);
        Patient patient = response.get();
        if(response.isPresent()){
            String accountId = patient.getAccountNo();
            RestTemplateResponseDTO restTemplateResponseDTO = restTemplate.getForObject(url+accountId, RestTemplateResponseDTO.class);
            List<Transactions> transactions = restTemplateResponseDTO.getBodyList();
            return  transactions;
        }
        return  new ArrayList<Transactions>();
    }

    public RestTemplateResponseDTO  deletePatientTransaction(String refId) {


        RestTemplateResponseDTO restTemplateResponseDTO=restTemplate.getForObject(url+"delete/"+refId,RestTemplateResponseDTO.class);



        return restTemplateResponseDTO;
    }

    public RestTemplateResponseDTO updatePatientTransactionById(Long id,Transactions transactions)
    {
        RestTemplateResponseDTO restTemplateResponseDTO=restTemplate.postForObject(url+"update/"+id,transactions,RestTemplateResponseDTO.class);

        return restTemplateResponseDTO;

    }
}
