package com.example.test.Controller;

import com.example.test.DTO.OpdErDTO;
import com.example.test.Model.OpdEr;
import com.example.test.Service.OpdErService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/opder")
public class OpdErController {
    @Autowired
    OpdErService opdErService;


    @PostMapping("/")
    public String save(@RequestBody OpdErDTO data)
    {
return this.opdErService.saveOpdErToAccounts(data);


    }

    }
    //@RequestMapping("/update")

   // @RequestMapping("/delete")





