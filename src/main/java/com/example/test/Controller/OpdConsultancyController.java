package com.example.test.Controller;

import com.example.test.DTO.OpdConsultancyDTO;
import com.example.test.Service.OpdConsultancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/opdconsultancy")
public class OpdConsultancyController {
    @Autowired
    OpdConsultancyService opdConsultancyService;

    @PostMapping("/")
    public String save(@RequestBody OpdConsultancyDTO data){

       return this.opdConsultancyService.saveOpdConsultancyToAccounts(data);

    }

}
