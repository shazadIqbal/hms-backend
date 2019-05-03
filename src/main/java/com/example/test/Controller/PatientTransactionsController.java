package com.example.test.Controller;

import com.example.test.Commons.Transactions;
import com.example.test.Service.PatientTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/patienttransactions")
public class PatientTransactionsController {
    @Autowired
    PatientTransactionsService patientTransactionsService;

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public List<Transactions> getPatientTransactions(@PathVariable("id") Long id){
        return patientTransactionsService.getPatientTransactions(id);
    }
}
