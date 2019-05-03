package com.example.test.Controller;

import com.example.test.DTO.OpdAdmitDTO;
import com.example.test.Repository.BedRepository;
import com.example.test.Service.OpdAdmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/opdadmit")
public class OpdAdmitController {
    @Autowired
    OpdAdmitService opdAdmitService;

    @PostMapping("/")
    public String save(@RequestBody OpdAdmitDTO opdAdmitDTO){
        return this.opdAdmitService.saveOpdAdmit(opdAdmitDTO);

    }

}
