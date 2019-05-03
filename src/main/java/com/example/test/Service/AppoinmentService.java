package com.example.test.Service;

import com.example.test.DTO.AppoinmentDTO;
import com.example.test.Model.Appoinment;
import com.example.test.Model.Patient;
import com.example.test.Repository.AppoinmentRepository;
import com.example.test.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppoinmentService {
    @Autowired
    AppoinmentRepository appoinmentRepository;
    @Autowired
    PatientRepository patientRepository;

    public String saveAppoinment(AppoinmentDTO appoinment ){

        Appoinment appoinment1= new Appoinment();
        appoinment1.setSelectDoctor(appoinment.getSelectDoctor());
        appoinment1.setAppoinmentDate(appoinment.getAppoinmentDate());
        appoinment1.setTime(appoinment.getTime());
        appoinment1.setId(appoinment.getId());
        appoinment1.setStatus("ACTIVE");
        Patient patient=patientRepository.getOne(appoinment.getId());
        if(patient!=null) {
            appoinment1.setPatientName(patient.getName());
            appoinment1.setPhoneNo(patient.getPhoneNo());
            appoinmentRepository.save(appoinment1);
        }
        else{
            return  "{\"patient not found\":1}";
        }


        return  "{\"saved successfully\":1}";






    }
    public List<Appoinment> deleteAppoinment(Long id){
        Appoinment app= appoinmentRepository.getOne(id);
        app.setStatus("INACTIVE");
        appoinmentRepository.save(app);

        List<Appoinment> responceList= getAllAppoinment();

        return responceList;


    }
    public Appoinment getAppoinmentById(Long id){
        Optional<Appoinment> app= appoinmentRepository.findById(id);
        if (app.isPresent()) {
            return app.get();
        }
        else {
            return  null;
        }



    }
    public List<Appoinment> getAppoinmentByDate (Date date){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String convertedDate = simpleDateFormat.format(date);
       List<Appoinment> appDate=appoinmentRepository.findByAppoinmentDate(convertedDate);

       return appDate;


    }
    public List<Appoinment> getAllAppoinment(){

        List<Appoinment> list= appoinmentRepository.findAll();
        List<Appoinment> responseList=new ArrayList<>();
        for(Appoinment A : list){
            if(A.getStatus().equalsIgnoreCase("ACTIVE")){

                responseList.add(A);
            }
        }
        return responseList;

    }
    public String statusDone(Long id){
        Appoinment app =appoinmentRepository.getOne(id);
        app.setStatus("DONE");
        appoinmentRepository.save(app);
        return  "{\"successful\":1};";

    }

    public List<Appoinment> getAppoinmentByStatus(String status){

        List<Appoinment> responseList = appoinmentRepository.findByStatus(status);

        return responseList;

    }
    public String updateAppoinment(AppoinmentDTO appoinment){
       Appoinment appoinment1= appoinmentRepository.findById(appoinment.getId()).get();
       appoinment1.setStatus("ACTIVE");
       appoinment1.setAppoinmentDate(appoinment.getAppoinmentDate());
       appoinment1.setId(appoinment.getId());
       appoinment1.setSelectDoctor(appoinment.getSelectDoctor());
       appoinment1.setTime(appoinment.getTime());
       appoinmentRepository.save(appoinment1);



        return "updated successfully";


    }










}
