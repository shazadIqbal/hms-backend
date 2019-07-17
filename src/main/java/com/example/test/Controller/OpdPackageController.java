package com.example.test.Controller;

import com.example.test.DTO.OpdPackageDTO;
import com.example.test.Service.OpdPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/opdpackage")
public class OpdPackageController {

    @Autowired
    OpdPackageService opdPackageService;


    @PostMapping("/")
    public String save(@RequestBody OpdPackageDTO data){

        return this.opdPackageService.saveOpdPackageToAccounts(data);

    }




}
