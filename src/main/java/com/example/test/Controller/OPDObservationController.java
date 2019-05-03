package com.example.test.Controller;

import com.example.test.DTO.OPDObservationDTO;
import com.example.test.Model.OPDObservation;
import com.example.test.Service.OPDObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/opdobservation")
public class OPDObservationController {
    @Autowired
    OPDObservationService opdObservationService;

    @PostMapping("/")
    public String save(@RequestBody OPDObservationDTO data){
        return this.opdObservationService.saveOpdObservationToAccounts(data);
    }
}
