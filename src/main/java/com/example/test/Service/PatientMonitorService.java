package com.example.test.Service;

import com.example.test.Commons.Transactions;
import com.example.test.DTO.PatientMonitorDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PatientMonitorService {

    @Autowired
    PatientRepository patientRepository;


    RestTemplate restTemplate = new RestTemplate();//connect two spring applications together


    public PatientMonitorDTO getPatientMonitor(Long id) {
        PatientMonitorDTO patientMonitorDTO = new PatientMonitorDTO();
        Optional<Patient> response = patientRepository.findById(id);
        RestTemplateResponseDTO restTemplateResponseDTO = new RestTemplateResponseDTO();
        Patient patient = response.get();

        if(response.isPresent()) {

            String accountId = patient.getAccountNo();


//        aa4f062d-a115-42aa-bdcd-78e324426137

            RestTemplateResponseDTO abc = restTemplate.getForObject("http://192.168.0.107:8081/api/transactions/" + accountId, RestTemplateResponseDTO.class);


            ObjectMapper mapper = new ObjectMapper();
            List<Transactions> transactions = mapper.convertValue(
                    abc.getBodyList(),
                    new TypeReference<List<Transactions>>() {
                    }
            );
            List<Transactions> er = new ArrayList<>();
            List<Transactions> opd = new ArrayList<>();
            List<Transactions> lab = new ArrayList<>();

            long dues = 0;
            transactions.forEach((v) ->
            {

                if (v.getOperationType().equalsIgnoreCase("ER")) {
                    er.add(v);
                } else if (v.getOperationType().equalsIgnoreCase("OPD")) {
                    opd.add(v);
                } else if (v.getOperationType().equalsIgnoreCase("LAB")) {
                    lab.add(v);
                }
            });

            long erTotal = 0;
            long opdTotal = 0;
            long labTotal = 0;

            for (Transactions e : er) {
                dues += e.getDues();
                erTotal += e.getReceivedAmount();
            }
            for (Transactions o : opd) {
                dues += o.getDues();
                opdTotal += o.getReceivedAmount();
            }
            for (Transactions l : lab) {
                dues += l.getDues();
                labTotal += l.getReceivedAmount();
            }
            long total = labTotal + opdTotal + erTotal;


            patientMonitorDTO.setId(patient.getId());
            patientMonitorDTO.setName(patient.getName());
            patientMonitorDTO.setNumber(patient.getPhoneNo());
            patientMonitorDTO.setDate(patient.getDate());

            patientMonitorDTO.setEr(erTotal);
            patientMonitorDTO.setLab(labTotal);
            patientMonitorDTO.setOpd(opdTotal);
            patientMonitorDTO.setTotal(total);
            patientMonitorDTO.setDues(dues);

            return patientMonitorDTO;
        }
        else
        {
            return new PatientMonitorDTO();
        }





    }
}