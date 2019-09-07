package com.example.test.Service;

import com.example.test.Commons.LabTestRegistration;
import com.example.test.DTO.OpdLabTestDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.Model.Patient;
import com.example.test.Model.PatientLabtestDetails;
import com.example.test.Model.User;
import com.example.test.Repository.PatientLabtestDetailsRepository;
import com.example.test.Repository.PatientRepository;
import com.example.test.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OpdLabTestService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientLabtestDetailsRepository patientLabtestDetailsRepository;

    @Autowired
    UserDao userDao;

    @Value("${transaction.url}")
    public  String  url;

    @Transient
    private UUID ref ;

//    RestTemplate restTemplate = new RestTemplate();
@Autowired
RestTemplate restTemplate;
    public String saveToAccounts(OpdLabTestDTO data) {

//        for(int i=0; i<data.getLabTests().length;i++){
            for(String labtest:data.getLabTests()){
        PatientLabtestDetails patientLabtestDetails = new PatientLabtestDetails();
        patientLabtestDetails.setCreatedDate(new Date());
//        patientLabtestDetails.setLabtestName(data.getLabTests()[i]);
                patientLabtestDetails.setLabtestName(labtest);
        patientLabtestDetails.setPatient(data.getPatient());
        patientLabtestDetails.setStatus("In Progress");
        patientLabtestDetailsRepository.save(patientLabtestDetails);
            }
//    }


        Patient patient = patientRepository.findById(data.getId()).get();
        TransactionRestDTO response = new TransactionRestDTO();
        response.setAccountNoUUID(patient.getAccountNo());
        response.setOperationType("LABTEST");
        response.setCreatedBy(username());
        response.setTransactionType("DEBIT");
        response.setReceivedAmount(data.getCashRecieve());
        response.setTotalAmount(data.getTotal());
        response.setDescription(descriptionlist(patient.getName(), data.getLabTests()));
        response.setCreatedAt(new Date());

        //refid


        response.setTransactionRefId(ref.randomUUID().toString());

        RestTemplateResponseDTO result = restTemplate.postForObject(url, response, RestTemplateResponseDTO.class);
        if (result.getCode().equalsIgnoreCase("200")) {

            return "{\"ADDED SUCCESFULLY\":1}";
        } else {
            return "{\"Some Thing Went Wrong\":1}";
        }



    }

    public String descriptionlist(String patientName, String[] labTest) {

        System.out.println(labTest.toString());
        StringBuilder f = new StringBuilder();
        for (int i = 0; i < labTest.length; i++) {
            f.append(labTest[i]);
            if (i < labTest.length - 1) {
                f.append(" ,");
            }

        }

        String des = patientName + "avails " + f;
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
    public RestTemplateResponseDTO getPatientLabtestDetails(){
        List<PatientLabtestDetails> patientLabtestDetails = patientLabtestDetailsRepository.findAll();
        RestTemplateResponseDTO response = new RestTemplateResponseDTO("200","Get Successfully",patientLabtestDetails);
        return response;
    }

    public List<LabTestRegistration> getLabtests(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiLmNvbSIsInNjb3BlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwiaXNzIjoiaHR0cDovL2RldmdsYW4uY29tIiwiaWF0IjoxNTY3ODc4MzIxLCJleHAiOjE1Njc4OTYzMjF9.SenIskJhEH0YXSR5cRNCsTZJpRNj8FkfkNnd-_HapvU");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        RestTemplateResponseDTO restTemplateResponseDTO = restTemplate.getForObject("http://localhost:8082/api/labtestregistration/", RestTemplateResponseDTO.class);
        ResponseEntity<RestTemplateResponseDTO> response = restTemplate.exchange("http://localhost:8082/api/labtestregistration/opd", HttpMethod.GET, entity, RestTemplateResponseDTO.class);
    List<LabTestRegistration> labTestRegistrations = response.getBody().getBodyList();
       return labTestRegistrations;
    }
    public RestTemplateResponseDTO changeLabtestDetailsStatus(Long id){
        Optional<PatientLabtestDetails> patientLabtest = patientLabtestDetailsRepository.findById(id);
       // PatientLabtestDetails patientLabtestDetails = patientLabtestDetailsRepository.findById(id).get();
        if(patientLabtest.isPresent()) {
            PatientLabtestDetails patientLabtestDetails = patientLabtest.get();
            patientLabtestDetails.setStatus("Completed");
            patientLabtestDetailsRepository.save(patientLabtestDetails);
            return new RestTemplateResponseDTO("200", "Updated Successfully");
        }
        else
        {
            return new RestTemplateResponseDTO("500", "No Value Present");
        }
    }


}