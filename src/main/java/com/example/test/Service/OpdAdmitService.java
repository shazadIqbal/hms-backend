package com.example.test.Service;
import com.example.test.DTO.OpdAdmitDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.DTO.TransactionRestDTO;
import com.example.test.Model.Bed;
import com.example.test.Model.Patient;
import com.example.test.Model.User;
import com.example.test.Repository.BedRepository;
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
import java.util.Optional;
import java.util.UUID;

@Service
public class OpdAdmitService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    BedRepository bedRepository;
    @Value("${transaction.url}")
    public String url;

    @Transient
    private UUID ref;

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    UserDao userDao;
    public String saveOpdAdmit(OpdAdmitDTO opdAdmitDTO) {


        Patient patient = patientRepository.findById(opdAdmitDTO.getPatientID()).get(); //it will get patient id
       Optional<Bed> bed = bedRepository.findById(opdAdmitDTO.getBedID());

        if (bed.isPresent()) {
            Bed bednew = bed.get();
            bednew.setOccupied(true);
            bednew.setBedType(opdAdmitDTO.getBedType());

            bedRepository.save(bednew);
            patient.setBedId(bednew.getId());
            patient.setDischarge(Boolean.FALSE);
            patientRepository.save(patient);
            TransactionRestDTO request = new TransactionRestDTO();
            request.setAccountNoUUID(patient.getAccountNo());
            request.setCreatedAt(new Date());
            request.setCreatedBy(username());
            request.setReceivedAmount(opdAdmitDTO.getCashRecieved());
            request.setTotalAmount(opdAdmitDTO.getPrice());
            request.setOperationType("ADMIT");
            request.setTransactionType("DEBIT");

            request.setDescription(opdAdmitdescriptionlist(patient.getName(), opdAdmitDTO.getBedID()));

            //refid

            request.setTransactionRefId(ref.randomUUID().toString());


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
//        OpdAdmitDTO opdAdmitDTO = new OpdAdmitDTO();
        Optional<Bed> bed = bedRepository.findById(bedID);
        String des;
        if (bed.isPresent()) {
            des ="NO DESCRIPTION AVAILAIBLE";
            return des;
        }
        else{
            return "BED NOT PRESENT";
        }

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

