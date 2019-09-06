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
    public List<Doctor> getDoctors(){

            return doctorService.getDoctors();
    }

//    Add a new doctor
    @RequestMapping( value = "/",method = RequestMethod.POST)
    public String postDoctorFromService(@RequestBody DoctorDTO doc){

        return doctorService.postDoctorFromService(doc);
    }

    @RequestMapping( value = "/{mrNo}",method = RequestMethod.DELETE)
    public List<Doctor> delDoctor(@PathVariable("mrNo") Long mrNo){
        return doctorService.delDoctor(mrNo);
    }

    @GetMapping("/{mrNo}")
    public Doctor getDoctorByID(@PathVariable("mrNo") Long mrNo){
       return  this.doctorService.getDocByID(mrNo);
    }

//    Update Existing Doctor
    @PostMapping("/{mrNo}/{mobile}")
    public String updateDoctorByID(@PathVariable("mrNo")Long mrNo,@PathVariable("mobile")String mobile,@RequestBody DoctorDTO doc){
        return  doctorService.updateDoctorFromService(mrNo,mobile,doc);
    }


}
