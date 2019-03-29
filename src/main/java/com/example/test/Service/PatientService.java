package com.example.test.Service;

import com.example.test.DTO.PatientDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

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
        patient.setName(pat.getName());
        patient.setCnic(pat.getCnic());
        patient.setPhoneNo(pat.getPhoneNo());
        patient.setAge(pat.getAge());
        patient.setGender(pat.getGender());
        patient.setAddress(pat.getAddress());
       patient.setStatus("Active");
        patientRepository.save(patient);
        return "{\"ADDED SUCCESFULLY\":1}";
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
}
