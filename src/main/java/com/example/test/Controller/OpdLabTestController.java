package com.example.test.Controller;

import com.example.test.DTO.OpdLabTestDTO;
import com.example.test.Service.OpdLabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
