package com.example.test.Service;

import com.example.test.DTO.AccountRestDTO;
import com.example.test.DTO.PatientDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Value("${account.url}")
    public String url;

    @Transient
    private UUID corrId;

    RestTemplate restTemplate = new RestTemplate();
    //Get Active Patients from Database
public List<Patient> getPatients(){
    List<Patient> list = patientRepository.findAll();
    List<Patient> responseList = new ArrayList<>();
    list.forEach(patient -> {
       if(patient.getStatus().equalsIgnoreCase("Active")){
           responseList.add(patient);
       }
    });
    return responseList;
}
//Get Patients By ID

    public Optional<Patient> getPatientsById(Long id){
    Optional<Patient> patients = patientRepository.findById(id);
    return patients;
    }
//Insert Patient into Database
    public String postPatient(PatientDTO pat){
    Patient patient = new Patient();
        AccountRestDTO accountRestDTO=new AccountRestDTO();
        Patient findPatientByMobile = patientRepository.findByPhoneNo(pat.getPhoneNo());
        if(findPatientByMobile.getPhoneNo()==null) {
            corrId = UUID.randomUUID();
            patient.setName(pat.getName());
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
            patient.setDate(new Date());

//       if patient is registered in gynyAndObs

            patientRepository.save(patient);
            //Creating new patient account
            accountRestDTO.setId(patient.getAccountNo());
            accountRestDTO.setGender(pat.getGender());
            accountRestDTO.setName(pat.getName());
            accountRestDTO.setAccountType("Patient Account");
            RestTemplateResponseDTO result = restTemplate.postForObject(url, accountRestDTO, RestTemplateResponseDTO.class);
//00 Means posted successfully 01 means duplicate

            return "00";
        }
        else{
            return "01";
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
        updatedPatient.setGender(pat.getGender());
        updatedPatient.setName(pat.getName());
        updatedPatient.setGynAndObsRegistration(pat.getGynAndObsRegistration() == null ? Boolean.FALSE : Boolean.TRUE);
        updatedPatient.setRegistrationDate(pat.getRegistrationDate());
        updatedPatient.setHusbandOfAndFatherOf(pat.getHusbandOfAndFatherOf());

        patientRepository.save(updatedPatient);
    return "{\" UPDATED SUCCESFULLY\":1}";
}


    public List<Patient> getAllGynePatient() {
        return patientRepository.getAllGynyObsPatients();
    }
}
