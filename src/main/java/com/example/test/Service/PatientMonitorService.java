package com.example.test.Service;

import com.example.test.DTO.PatientMonitorDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PatientMonitorService {

    @Autowired
    PatientRepository patientRepository;





    public PatientMonitorDTO getPatientMonitor(Long id)
    {
        PatientMonitorDTO patientMonitorDTO=new PatientMonitorDTO();
        Optional<Patient> response=patientRepository.findById(id);



        if(response.isPresent())
        {
            Patient patient=response.get();
            patientMonitorDTO.setId(patient.getId());
            patientMonitorDTO.setName(patient.getName());
            patientMonitorDTO.setNumber(patient.getPhoneNo());
            patientMonitorDTO.setDate(patient.getDate());

            return patientMonitorDTO;
        }else{
             return new PatientMonitorDTO();
        }
    }
}
