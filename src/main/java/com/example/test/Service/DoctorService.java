package com.example.test.Service;


import com.example.test.DTO.DoctorDTO;
import com.example.test.Model.Directory;
import com.example.test.Model.Doctor;
import com.example.test.Repository.DirectoryRepository;
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
    @Autowired
    DirectoryRepository directoryRepository;

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
            doctorDto.setSallary(doctor.getSallary());
            doctorDto.setFees(doctor.getFees());

            responseList.add(doctorDto);
        });
       return  responseList;
    }

    public String postDoctorFromService(DoctorDTO doc){
       // listDoctor.add(doc);
        Doctor doctor = new Doctor();
        Directory directory=new Directory();
        //doctor.setMrno(doc.getMrNo());
        doctor.setFullName(doc.getFullName());
        doctor.setCreatedDate(new Date());
        doctor.setAddress(doc.getAddress());
        doctor.setCnic(doc.getCnic());
        doctor.setGender(doc.getGender());
        doctor.setSallary(doc.getSallary());
        doctor.setFees(doc.getFees());
        directory.setName(doc.getFullName());
        directory.setAddress(doc.getAddress());
        directory.setStatus("Active");
        directory.setErNo(doc.getEmrNo());
        directory.setNumber(doc.getMobile());
        doctorRepository.save(doctor);

        directoryRepository.save(directory);






        return "ADDED SUCCESFULLY";

    }

    public String delDoctor(){
        //listDoctor.clear();
        return "DELETED SUCCESSFULLY";
    }

}
