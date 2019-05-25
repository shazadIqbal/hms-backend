package com.example.test.Service;

import com.example.test.Commons.Transactions;
import com.example.test.DTO.PatientMonitorDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Patient;
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
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PatientMonitorService {

    @Value("${transaction.url}")
    public String url;

    @Autowired
    PatientRepository patientRepository;


    RestTemplate restTemplate = new RestTemplate();//connect two spring applications together


    public PatientMonitorDTO getPatientMonitor(Long id) {
        PatientMonitorDTO patientMonitorDTO = new PatientMonitorDTO();
        Optional<Patient> patientModel = patientRepository.findById(id);
       // RestTemplateResponseDTO restTemplateResponseDTO = new RestTemplateResponseDTO();
        Patient patient = patientModel.get();

        if(patientModel.isPresent()) {

            String accountId = patient.getAccountNo();

            RestTemplateResponseDTO restResponse = restTemplate.getForObject(url + accountId, RestTemplateResponseDTO.class);


            ObjectMapper mapper = new ObjectMapper();
            List<Transactions> transactions = mapper.convertValue(
                    restResponse.getBodyList(),
                    new TypeReference<List<Transactions>>() {
                    }
            );
            List<Transactions> er = new ArrayList<>();
            List<Transactions> opd = new ArrayList<>();
            List<Transactions> lab = new ArrayList<>();
            List<Transactions> admit = new ArrayList<>();
            List<Transactions> gyne = new ArrayList<>();
            List<Transactions> obs = new ArrayList<>();

            long dues = 0;
            transactions.forEach((v) ->
            {

                if (v.getOperationType().equalsIgnoreCase("ER")) {
                    er.add(v);
                } else if (v.getOperationType().equalsIgnoreCase("CONSULTANCY")) {
                    opd.add(v);
                } else if (v.getOperationType().equalsIgnoreCase("LABTEST")) {
                    lab.add(v);
                } else if (v.getOperationType().equalsIgnoreCase("ADMIT")) {
                    admit.add(v);
                    // admitLabel = v.getDiscription()
                    patientMonitorDTO.setAdmitLabel(v.getDescription());
                } else if (v.getOperationType().equalsIgnoreCase("GYNY")){
                    gyne.add(v);
                } else if (v.getOperationType().equalsIgnoreCase("OBSERVATION")){
                    obs.add(v);
                }


            });

            long erTotal = 0;
            long opdTotal = 0;
            long labTotal = 0;
            long admitTotal = 0;
            long gyneTotal = 0;
            long obsTotal = 0;

            for (Transactions e : er) {
                dues += e.getDues();
                erTotal += e.getTotalAmount();
            }
            for (Transactions o : opd) {
                dues += o.getDues();
                opdTotal += o.getTotalAmount();
            }
            for (Transactions l : lab) {
                dues += l.getDues();
                labTotal += l.getTotalAmount();
            }
            // loop for admit
            for (Transactions a : admit) {
                dues += a.getDues();
                admitTotal += a.getTotalAmount();
            }
            for (Transactions g : gyne) {
                dues += g.getDues();
                gyneTotal += g.getTotalAmount();
            }
            for (Transactions ob : obs) {
                dues += ob.getDues();
                obsTotal += ob.getTotalAmount();
            }


            // plus admit in total
            long total = labTotal + opdTotal + erTotal + admitTotal + gyneTotal + obsTotal;


            patientMonitorDTO.setId(patient.getId());
            patientMonitorDTO.setName(patient.getName());
            patientMonitorDTO.setNumber(patient.getPhoneNo());
            patientMonitorDTO.setDate(patient.getDate());
            patientMonitorDTO.setRegistrationDate(patient.getRegistrationDate());
            patientMonitorDTO.setGynAndObsRegistration(patient.getGynAndObsRegistration());
            patientMonitorDTO.setHusbandOfAndFatherOf(patient.getHusbandOfAndFatherOf());
            patientMonitorDTO.setEr(erTotal);
            patientMonitorDTO.setLab(labTotal);
            patientMonitorDTO.setOpd(opdTotal);
            patientMonitorDTO.setGyne(gyneTotal);
            patientMonitorDTO.setObs(obsTotal);
            patientMonitorDTO.setTotal(total);
            // new field for admit
            patientMonitorDTO.setAdmit(admitTotal);
            // new field for admitLabel
            patientMonitorDTO.setDues(dues);

            return patientMonitorDTO;
        }
        else
        {
            return new PatientMonitorDTO();
        }





    }
}
