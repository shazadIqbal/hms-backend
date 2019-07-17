package com.example.test.Service;

import com.example.test.DTO.OpdPackageDTO;
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
public class OpdPackageService {

    @Autowired
    PatientRepository patientRepository;

    @Transient
    private UUID ref;

    @Value("http://localhost:8083/api/transactions/")
    public String url;

    RestTemplate restTemplate = new RestTemplate();

    public String saveOpdPackageToAccounts(OpdPackageDTO data){

        Patient patient = patientRepository.findById(data.getId()).get();
        TransactionRestDTO request = new TransactionRestDTO();
        request.setAccountNoUUID(patient.getAccountNo());
        request.setReceivedAmount(data.getCashRecieved());
        request.setTotalAmount(data.getTotal());
        request.setOperationType("PACKAGE");
        request.setTransactionRefId(ref.randomUUID().toString());
        request.setDescription(descriptionList(patient.getName(),data.getPackageName(),data.getPackageFacility()));
        RestTemplateResponseDTO response = restTemplate.postForObject(url, request,RestTemplateResponseDTO.class);

        if (response.getCode().equalsIgnoreCase("200")){
            return "{\"ADDED SUCCESFULLY\":1}";
        }
        else{
            return "{\"Some Thing Went Wrong\":1}";
        }


    }

    public String descriptionList(String patientName, String packageName, String packageFacility){

        String des = patientName + "avails package" + packageName + "with facility" + packageFacility;
        return des;
    }






}
