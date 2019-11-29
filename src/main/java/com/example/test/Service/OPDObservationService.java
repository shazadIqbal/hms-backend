package com.example.test.Service;

import com.example.test.DTO.OPDObservationDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.Model.Doctor;
import com.example.test.Model.Patient;
import com.example.test.Model.User;
import com.example.test.Repository.PatientRepository;
import com.example.test.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import java.util.Date;
import java.util.UUID;

@Service
public class OPDObservationService {

    @Autowired
    PatientRepository patientRepository;
    @Value("${transaction.url}")
    public String url;

    @Autowired
    UserDao userDao;


    @Transient
    private UUID ref;

    @Autowired
    RestTemplate restTemplate;

    public String saveOpdObservationToAccounts(OPDObservationDTO data){
        Patient patient = patientRepository.findById(data.getId()).get();
       // patient.setObsRegisteration(true);
        TransactionRestDTO request = new TransactionRestDTO();
        request.setAccountNoUUID(patient.getAccountNo());
        request.setCreatedBy(username());
        request.setCreatedAt(new Date());
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
        String des = "The" + patientName + " avails " + " this "+ doctors.getFullName();
        return des;
    }

    public String username()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDao.findByEmail(username);

        return  user.getName();
    }
}
