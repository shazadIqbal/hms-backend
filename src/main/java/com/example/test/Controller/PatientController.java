package com.example.test.Controller;

import com.example.test.DTO.PatientDTO;
import com.example.test.Model.Patient;
import com.example.test.Repository.PatientRepository;
import com.example.test.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;
    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }


    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public Optional<Patient> getPatientsById(@PathVariable("id") Long id){
        return patientService.getPatientsById(id);
    }

    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public String postPatient(@RequestBody PatientDTO pat){

        return patientService.postPatient(pat);
    }

    @RequestMapping(value = "/" ,method = RequestMethod.DELETE)
    public String deletePatient(){
        return patientService.delPatient();

    }
    //Delete Patients By ID
    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public List<Patient> deletePatientById(@PathVariable("id") Long id){
        return patientService.deletePatientsById(id);

    }
    //Active Patients By ID
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public List<Patient> activePatientById(@PathVariable("id") Long id){
        return patientService.activePatientsById(id);

    }
    // Update patient record
    @PutMapping("/update/{id}")
    public  String updatePatientByID(@PathVariable("id") Long id,@RequestBody PatientDTO patient){
        return patientService.updatePatientByID(id,patient);
        //return  null;
    }

@GetMapping("/allgynyobs")
public List<Patient> getAllGynePatient(){
        return patientService.getAllGynePatient();
}

}
