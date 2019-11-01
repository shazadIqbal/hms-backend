package com.example.test.Service;

import com.example.test.DTO.AccountRestDTO;
import com.example.test.DTO.PatientDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Value("${transaction.url}")
    public String url;

    @Value("${account.url}")
    public String accountUrl;

    @Autowired
    UserDao userDao;
    @Transient
    private UUID corrId;

    RestTemplate restTemplate = new RestTemplate();

    //Get Active Patients from Database
    public List<Patient> getPatients() {
        List<Patient> list = patientRepository.getAllPatients();
//    List<Patient> responseList = new ArrayList<>();
//    list.forEach(patient -> {
//       if(patient.getStatus().equalsIgnoreCase("Active")){
//           responseList.add(patient);
//       }
//    });
        return list;
    }
//Get Patients By ID

    public Optional<Patient> getPatientsById(Long id) {
        Optional<Patient> patients = patientRepository.findById(id);
        return patients;
    }

    //Insert Patient into Database
    public String postPatient(PatientDTO pat) {
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date today = new Date();
//        Date todayWithZeroTime = formatter.parse(formatter.format(today));
            Patient patient = new Patient();
            AccountRestDTO accountRestDTO = new AccountRestDTO();
            Patient findPatientByMobile = patientRepository.findByPhoneNo(pat.getPhoneNo());
            if (findPatientByMobile == null) {
                corrId = UUID.randomUUID();
                patient.setName(pat.getName());

                patient.setCreatedAt(new Date());
                patient.setCreatedBy(username());
                patient.setCnic(pat.getCnic());
                patient.setPhoneNo(pat.getPhoneNo());
                patient.setAge(pat.getAge());
                patient.setGender(pat.getGender());
                patient.setAddress(pat.getAddress());
                patient.setHusbandOfAndFatherOf(pat.getHusbandOfAndFatherOf());
                patient.setRegistrationDate(pat.getRegistrationDate());
                patient.setGynAndObsRegistration(pat.getGynAndObsRegistration());
                patient.setStatus("Active");
                patient.setAccountNo(corrId.toString());
                patient.setStatus("Active");
//                Date date = new Date();
//                String pattern = "yyyy-MM-dd";
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//                String convertedDate = simpleDateFormat.format(date);
                patient.setDate(new Date());
                patient.setBedId(-1L);
                patient.setDischarge(Boolean.FALSE);

//       if patient is registered in gynyAndObs

//            patientRepository.save(patient);
                //Creating new patient account
                accountRestDTO.setId(patient.getAccountNo());
                accountRestDTO.setGender(pat.getGender());
                accountRestDTO.setName(pat.getName());
                accountRestDTO.setAccountType("Patient Account");
                RestTemplateResponseDTO result = restTemplate.postForObject(accountUrl, accountRestDTO, RestTemplateResponseDTO.class);
//00 Means posted successfully 01 means duplicate
        if(result.getCode().equalsIgnoreCase("200")){
            patientRepository.save(patient);
            return "{\"SAVEDSUCCESFULLY\":1}";
        }
        else{
            return "{\"NOT SUCCESFULL\":1}";
        }

            } else {
                return "{\"NOT SUCCESFULL\":1}";
            }


        }



    public String delPatient(){
    return "DELETED SUCCESFULLY";
    }


//Delete Patients By ID
public List<Patient> deletePatientsById(Long id){
    Optional<Patient> patients = patientRepository.findById(id);
    if(patients.isPresent()){
        Patient patientdel = patients.get();
        patientdel.setStatus("Inactive");
         patientRepository.save(patientdel);

    }
//    List<Patient> resPatient = this.getPatients();
//return "Deleted Successfully";
    return this.getPatients();

}

//Active Patient By ID
public List<Patient> activePatientsById(Long id){
    Optional<Patient> patients = patientRepository.findById(id);
    if(patients.isPresent()){
        Patient patientdel = patients.get();
        patientdel.setStatus("Active");
        patientRepository.save(patientdel);

    }
//    List<Patient> resPatient = this.getPatients();
//return "Deleted Successfully";
    return this.getPatients();

}

public String updatePatientByID(Long id,PatientDTO pat){
    Optional<Patient> patient = patientRepository.findById(id);

        Patient updatedPatient = patient.get();
        updatedPatient.setAddress(pat.getAddress());
        updatedPatient.setAge(pat.getAge());
        updatedPatient.setCnic(pat.getCnic());
        updatedPatient.setPhoneNo(pat.getPhoneNo());
        updatedPatient.setUpdatedBy(username());
        updatedPatient.setUpdateAt(new Date());

        updatedPatient.setGender(pat.getGender());
        updatedPatient.setName(pat.getName());
        updatedPatient.setGynAndObsRegistration(pat.getGynAndObsRegistration() == null || !pat.getGynAndObsRegistration()  ? Boolean.FALSE : Boolean.TRUE);
        updatedPatient.setRegistrationDate(pat.getRegistrationDate());
        updatedPatient.setHusbandOfAndFatherOf(pat.getHusbandOfAndFatherOf());

        patientRepository.save(updatedPatient);
    return "{\" UPDATED SUCCESFULLY\":1}";
}


    public List<Patient> getAllGynePatient() {
        return patientRepository.getAllGynyObsPatients();
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
