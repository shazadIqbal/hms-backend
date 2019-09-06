package com.example.test.Controller;

import com.example.test.Commons.LabTestRegistration;
import com.example.test.DTO.OpdLabTestDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.PatientLabtestDetails;
import com.example.test.Service.OpdLabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/opdlabtest")
public class OpdLabTestController {

    @Autowired
    OpdLabTestService opdLabTestService;

    @PostMapping("/")
    public String save(@RequestBody OpdLabTestDTO opdLabTest){
        return this.opdLabTestService.saveToAccounts(opdLabTest);

    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public RestTemplateResponseDTO getPatientLabtestDetails(){
        return opdLabTestService.getPatientLabtestDetails();
    }

    @RequestMapping(value = "/labtest/", method = RequestMethod.GET)
    public List<LabTestRegistration> getLabTestRegistration(){
       return opdLabTestService.getLabtests();
    }

}
