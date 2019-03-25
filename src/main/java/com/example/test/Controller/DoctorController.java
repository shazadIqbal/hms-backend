package com.example.test.Controller;


import com.example.test.DTO.DoctorDTO;
import com.example.test.Model.Doctor;
import com.example.test.Repository.DoctorRepository;
import com.example.test.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorRepository doctorRepository;

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<DoctorDTO> getDoctors(){

            return doctorService.getDoctors();
    }

    @RequestMapping( value = "/",method = RequestMethod.POST)
    public String postDoctorFromService(@RequestBody DoctorDTO doc){
        return doctorService.postDoctorFromService(doc);
    }

    @RequestMapping( value = "/",method = RequestMethod.DELETE)
    public String delDoctor(){
        return doctorService.delDoctor();
    }
}
