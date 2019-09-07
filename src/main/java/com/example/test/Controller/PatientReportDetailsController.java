package com.example.test.Controller;

import com.example.test.Commons.PatientReport;
import com.example.test.Service.PatientReportDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient/report")
public class PatientReportDetailsController {
    @Autowired
    PatientReportDetailsService patientReportDetailsService;

    @RequestMapping(value = "/{patientId}", method = RequestMethod.GET)
    public List<PatientReport> getPatientReport(@PathVariable("patientId") Long patientId){
        return patientReportDetailsService.getPatientReportByPatientId(patientId);
    }
}