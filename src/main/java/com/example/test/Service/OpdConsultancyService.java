package com.example.test.Service;

import com.example.test.DTO.OpdConsultancyDTO;
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
public class OpdConsultancyService {
    @Autowired
    PatientRepository patientRepository;

    @Transient
    private UUID ref;

    @Autowired
    UserDao userDao;

    @Value("${transaction.url}")
    public String url;

    @Autowired
    RestTemplate restTemplate;

    public String saveOpdConsultancyToAccounts(OpdConsultancyDTO data) {



        Patient patient = patientRepository.findById(data.getId()).get();
        TransactionRestDTO request = new TransactionRestDTO();
        request.setAccountNoUUID(patient.getAccountNo());
        request.setReceivedAmount(data.getCashRecieved());
        request.setTotalAmount(data.getTotal());
        request.setCreatedAt(new Date());
        request.setCreatedBy(username());
        request.setFlag(data.isFlag());
        request.setOperationType("CONSULTANCY");
        // SSET TRAnsaction reff id
        request.setTransactionRefId(ref.randomUUID().toString());

        request.setTransactionType("DEBIT");
        request.setDescription(descriptionlist(patient.getName(), data.getDoctors()));
        request.setShareDescription(shareDescription(patient.getName(), data.getDoctors()));
        request.setSharePercent(data.getDoctors().getShare());
        request.setShareAccountNo(data.getDoctors().getAccountNo());
        RestTemplateResponseDTO response = restTemplate.postForObject(url, request, RestTemplateResponseDTO.class);
        if (response.getCode().equalsIgnoreCase("200")) {

            return "{\"ADDED SUCCESFULLY\":1}";
        } else {
            return "{\"Some Thing Went Wrong\":1}";
        }
    }

    public String descriptionlist(String patientName, Doctor doctors) {

       // System.out.println(facilities.toString());


        String des = patientName + " Avails OPD CONSULTANCY BY Dr."+ doctors.getFullName();
        return des;


    }
    public String shareDescription(String patientName, Doctor doctors){
        String des = "Dr. " + doctors.getFullName() + " shares via " + patientName;
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