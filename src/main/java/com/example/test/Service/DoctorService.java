package com.example.test.Service;


import com.example.test.DTO.DoctorDTO;
import com.example.test.Model.Doctor;
import com.example.test.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DoctorService {
   // List listDoctor=new ArrayList<>();

    @Autowired
    DoctorRepository doctorRepository;

    public List<DoctorDTO> getDoctors(){
        List<Doctor> list = doctorRepository.findAll();
        List<DoctorDTO> responseList = new ArrayList<>();
        list.forEach(doctor ->{
            DoctorDTO doctorDto = new DoctorDTO();
            doctorDto.setMrNo(doctor.getMrno());
            doctorDto.setFullName(doctor.getFullName());
            doctorDto.setAddress(doctor.getAddress());
            doctorDto.setCreatedDate(doctor.getCreatedDate());
            doctorDto.setCnic(doctor.getCnic());
            doctorDto.setGender(doctor.getGender());

            responseList.add(doctorDto);
        });
       return  responseList;
    }

    public String postDoctorFromService(DoctorDTO doc){
       // listDoctor.add(doc);
        Doctor doctor = new Doctor();
        doctor.setMrno(doc.getMrNo());
        doctor.setFullName(doc.getFullName());
//        doctor.setMobile(doc.getMobile());
//        doctor.setEmrNo(doc.getEmrNo());
//        doctor.setNationality(doc.getNationality());
//        doctor.setDaysservice(doc.getDaysservice());
//        doctor.setEmail(doc.getEmail());
//        doctor.setSpeciality(doc.getSpeciality());
//        doctor.setQualification(doc.getQualification());
//        doctor.setHoursday(doc.getHoursday());
        doctor.setPosition(doc.getPosition());
        doctor.setReligion(doc.getReligion());
        doctor.setSallary(doc.getSallary());
        doctor.setCreatedDate(new Date());
        doctor.setAddress(doc.getAddress());
        doctor.setCnic(doc.getCnic());
        doctor.setGender(doc.getGender());
//        doctor.setDateOfbirth(doc.getDateOfbirth());
//        doctor.setTimeIn(doc.getTimeIn());
//        doctor.setTimeOut(doc.getTimeOut());

        doctorRepository.save(doctor);

        return "ADDED SUCCESFULLY";

    }

    public String delDoctor(){
        //listDoctor.clear();
        return "DELETED SUCCESSFULLY";
    }

}
