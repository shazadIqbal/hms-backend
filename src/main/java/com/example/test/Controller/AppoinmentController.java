package com.example.test.Controller;

import com.example.test.DTO.AppoinmentDTO;
import com.example.test.Model.Appoinment;
import com.example.test.Repository.AppoinmentRepository;
import com.example.test.Service.AppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/appoinment")
public class AppoinmentController {
    @Autowired
    AppoinmentService appoinmentService;

    @Autowired
    AppoinmentRepository appoinmentRepository;

    @PostMapping("/")
    public String addAppoinment(@RequestBody AppoinmentDTO appoinment ){

        this.appoinmentService.saveAppoinment(appoinment);
        return  "{\"appoinment saved\":1}";
    }

    @DeleteMapping("/{id}")
    public List<Appoinment> deleteAppoinment(@PathVariable Long id  )
    {
        return this.appoinmentService.deleteAppoinment(id);


    }
    @GetMapping("/{id}")
    public Appoinment getAppoinmentById(@PathVariable("id") Long id ){

        return this.appoinmentService.getAppoinmentById(id);
    }
    @GetMapping("/filter/{date}")
    public List<Appoinment> getAppoinmentByDate(@PathVariable ("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date){

        return this.appoinmentService.getAppoinmentByDate( date );

    }
    @GetMapping("/")
    public List<Appoinment> getAllAppoinment(){
        return  this.appoinmentService.getAllAppoinment();
    }

    @PatchMapping("/complete/{id}")
    public String statusDone(@PathVariable ("id") Long id ){

        this.appoinmentService.statusDone(id);
        return  "{\"successful\":1}";
    }
    @GetMapping("/filterbystatus/{status}")
    public List<Appoinment> getAppoinmentByStatus(@PathVariable ("status") String status){

        return this.appoinmentService.getAppoinmentByStatus(status);

    }
    @PutMapping("/update/")
    public String updateAppoinment(@RequestBody AppoinmentDTO appoinment ){

        this.appoinmentService.updateAppoinment(appoinment);
        return "update successfully";

    }



}
