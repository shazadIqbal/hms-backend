package com.example.test.Service;

import com.example.test.DTO.OpdErDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import java.util.UUID;


@Service
public class OpdErService {
    @Autowired
    PatientRepository patientRepository;

   public OpdErDTO erDTO=new OpdErDTO();

    @Transient
    private UUID ref;
    RestTemplate restTemplate = new RestTemplate();

    @Value("${transaction.url}")
    public  String  url;

//    public String saveOpdEr(OpdErDTO data){
//        saveOpdErAccounts(data);
//        OpdEr opdEr=new OpdEr();
//        opdEr.setId(data.getId());
//        opdEr.setFacilities(data.getFacilities());
//        opdEr.setDiscount(data.getDiscount());
//        return "SAVED";







    public String saveOpdErToAccounts(OpdErDTO accountData){
        Patient patient=patientRepository.findById(accountData.getId()).get();
        TransactionRestDTO responce=new TransactionRestDTO();
        responce.setAccountNoUUID(patient.getAccountNo());
        responce.setReceivedAmount(accountData.getCashRecieve());
        responce.setTotalAmount(accountData.getTotal());
        responce.setOperationType("Er");
        responce.setDescription(descriptionlist(patient.getName(),accountData.getFacilities()));
        responce.setTransactionType("DEBIT");

        //refid

        responce.setTransactionRefId(ref.randomUUID().toString());

        RestTemplateResponseDTO result=restTemplate.postForObject(url,responce,RestTemplateResponseDTO.class);
       if(result.getCode().equalsIgnoreCase("200")) {

           return "{\"ADDED SUCCESFULLY\":1}";
       }
       else {
         return   "{\"Some Thing Went Wrong\":1}";
       }




    }
//    public OpdErDTO getOpdEr(){
//
//    //  ZOHAIB BHAI KI APPLICATION SAY DATA AYA farz karain (data) name kay object mai;
//        OpdErDTO responce=new OpdErDTO();
//
//       // responce.setTotal(data.gettotal);
//        // responce.setdues(data.getdues);
//        Patient patientInfo=patientRepository.findById(responce.getId()).get();
//
//
//
//
//
//
//
//      return null;
//    }
    public String descriptionlist(String patientName, String[] facilities){

        System.out.println(facilities.toString());
        StringBuilder f= new StringBuilder();
        for(int i=0; i<facilities.length;i++)
        {
            f.append(facilities[i]);
            if(i<facilities.length-1){
                f.append(" ,");
            }

        }

        String des = "Patient name "+patientName + " avails " + f + " by ER";
        return des;

    }

}
