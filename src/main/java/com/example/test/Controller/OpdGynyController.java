package com.example.test.Controller;

import com.example.test.DTO.OpdConsultancyDTO;
import com.example.test.DTO.OpdGynyDTO;
import com.example.test.Service.OpdConsultancyService;
import com.example.test.Service.OpdGynyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/opdGyny")
public class OpdGynyController {

   @Autowired
    OpdGynyService opdGynyService;

    @PostMapping("/")
    public String save(@RequestBody OpdGynyDTO data){

        return this.opdGynyService.saveOpdGynyToAccounts(data);


    }




}
