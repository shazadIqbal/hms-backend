package com.example.test.Controller;


import com.example.test.Commons.Transactions;
import com.example.test.DTO.PatientMonitorDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Service.PatientMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/monitor")
public class PatientMonitorController {
    @Autowired
    PatientMonitorService patientMonitorService;


    @GetMapping("/{id}")
    public PatientMonitorDTO getPatientMonitor(@PathVariable("id") Long id)
    {
        return patientMonitorService.getPatientMonitor(id);
    }



}
