package com.example.test.Controller;

import com.example.test.DTO.PatientPackageDTO;
import com.example.test.Model.PatientPackage;
import com.example.test.Repository.PatientPackageRepository;
import com.example.test.Service.PatientPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/addpackage")
public class PatientPackageController {

    @Autowired
    PatientPackageService patientPackageService;

    @Autowired
    PatientPackageRepository patientPackageRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PatientPackage> getPackages(){
        return patientPackageService.getPackages();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postPatientPackage(@RequestBody PatientPackageDTO pack){
        return patientPackageService.postPackage(pack);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<PatientPackage> deletePackageById(@PathVariable("id") Long id){
        return patientPackageService.deletePackageById(id);
    }

}
