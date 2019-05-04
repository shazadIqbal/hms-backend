package com.example.test.Service;
import com.example.test.DTO.BedDto;
import com.example.test.DTO.OpdAdmitDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.Model.Bed;
import com.example.test.Model.Patient;
import com.example.test.Repository.BedRepository;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.util.Optional;

@Service
public class OpdAdmitService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    BedRepository bedRepository;
    @Value("${transaction.url}")
    public String url;

    RestTemplate restTemplate = new RestTemplate();

    public String saveOpdAdmit(OpdAdmitDTO opdAdmitDTO) {
        Patient patient = patientRepository.findById(opdAdmitDTO.getPatientID()).get(); //it will get patient id
        Optional<Bed> bed = bedRepository.findById(opdAdmitDTO.getBedID());
        if (bed.isPresent()) {
            Bed bednew = bed.get();
            bednew.setOccupied(true);
            //bedRepository.save(bednew);
            TransactionRestDTO request = new TransactionRestDTO();
            request.setAccountNoUUID(patient.getAccountNo());
            request.setReceivedAmount(opdAdmitDTO.getCashRecieved());
            request.setTotalAmount(opdAdmitDTO.getPrice());
            request.setOperationType("ADMIT");
            request.setTransactionType("DEBIT");
            request.setDescription(opdAdmitdescriptionlist(patient.getName(), opdAdmitDTO.getBedID()));
            RestTemplateResponseDTO result = restTemplate.postForObject(url, request, RestTemplateResponseDTO.class);
            if (result.getCode().equalsIgnoreCase("200")) {

                return "{\"ADMITTED SUCCESFULLY\":1}";
            } else {
                return "{\"Some Thing Went Wrong\":1}";
            }

        }
        else
        {
            return "No bed";
        }
    }

    public String opdAdmitdescriptionlist(String patientName, long bedID){
        String des = "  This  "+patientName + " avails " + " this "+ bedID;
        return des;
    }

    }

