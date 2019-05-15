package com.example.test.Service;


import com.example.test.DTO.AccountRestDTO;
import com.example.test.DTO.DoctorDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Directory;
import com.example.test.Model.Doctor;
import com.example.test.Repository.DirectoryRepository;
import com.example.test.Repository.DoctorRepository;
//import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import javax.print.Doc;
import javax.validation.constraints.Null;
import java.util.*;

@Service
public class DoctorService {
   // List listDoctor=new ArrayList<>();

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DirectoryRepository directoryRepository;
    @Value("${account.url}")
    public String url;

    @Transient
    private UUID corrId;

    RestTemplate restTemplate = new RestTemplate();

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
            doctorDto.setMobile(doctor.getMobile());
            doctorDto.setEmrNo(doctor.getEmrNo());
            doctorDto.setAddress(doctor.getAddress());
            doctorDto.setDateOfbirth(doctor.getDateOfbirth());
            doctorDto.setNationality(doctor.getNationality());
//            doctorDto.setQualification(doctor.getQualification());
            doctorDto.setReligion(doctor.getReligion());
            doctorDto.setHoursday(doctor.getHoursday());
            doctorDto.setHoursday(doctor.getHoursday());
            doctorDto.setDaysservice(doctor.getDaysservice());
            doctorDto.setPosition(doctor.getPosition());
            doctorDto.setDateOfbirth(doctor.getDateOfbirth());
            doctorDto.setTimeIn(doctor.getTimeIn());
            doctorDto.setTimeOut(doctor.getTimeOut());
            doctorDto.setQualification(doctor.getQualification());
            doctorDto.setAccountNo(doctor.getAccountNo());
            doctorDto.setShare(doctor.getShare());
            responseList.add(doctorDto);
        });
       return  responseList;
    }

    public String postDoctorFromService(DoctorDTO doc){
        Doctor doctor = new Doctor();
        Directory directory=new Directory();
        AccountRestDTO accountRestDTO=new AccountRestDTO();
        corrId = UUID.randomUUID();
        doctor.setAccountNo(corrId.toString());
        doctor.setFullName(doc.getFullName());
        doctor.setCreatedDate(new Date());
        doctor.setAddress(doc.getAddress());
        doctor.setCnic(doc.getCnic());
        doctor.setFees(doc.getFees());
        doctor.setGender(doc.getGender());
        doctor.setSallary(doc.getSallary());
        doctor.setMobile(doc.getMobile());
        doctor.setEmail(doc.getEmail());
        doctor.setDateOfbirth(doc.getDateOfbirth());
        doctor.setSpeciality(doc.getSpeciality());
        doctor.setReligion(doc.getReligion());
        doctor.setPosition(doc.getPosition());
        doctor.setEmrNo(doc.getEmrNo());
        doctor.setDaysservice((doc.getDaysservice()));
        doctor.setNationality((doc.getNationality()));
        doctor.setEmrNo(doc.getEmrNo());
        doctor.setSpeciality(doc.getSpeciality());
        doctor.setHoursday(doc.getHoursday());
        doctor.setTimeIn(doc.getTimeIn());
        doctor.setTimeOut(doc.getTimeOut());
        doctor.setQualification(doc.getQualification());
        doctor.setShare(doc.getShare());
        directory.setName(doc.getFullName());
        directory.setAddress(doc.getAddress());
        directory.setStatus("Active");
        directory.setErNo(doc.getEmrNo());
        directory.setNumber(doc.getMobile());
        doctorRepository.save(doctor);
        directoryRepository.save(directory);
        //Creating new Doctor account
        accountRestDTO.setId(doctor.getAccountNo());
        accountRestDTO.setGender(doctor.getGender());
        accountRestDTO.setName(doctor.getFullName());
        accountRestDTO.setAccountType("Doctor Account");
        RestTemplateResponseDTO result=restTemplate.postForObject(url,accountRestDTO,RestTemplateResponseDTO.class);
        return "{\"ADDED SUCCESFULLY\":1}";

    }
    public String updateDoctorFromService(Long mrNo,String mobile,DoctorDTO doc){
        Doctor doctor = new Doctor();
       Optional<Doctor> updateDoc = doctorRepository.findById(mrNo);
       Directory directory = directoryRepository.findByNumber(mobile);

        if(updateDoc.isPresent()){
           updateDoc.get();
//           Directory diretoryObj =new Directory();
           updateDoc.get().setFullName(doc.getFullName());
           updateDoc.get().setCreatedDate(new Date());
           updateDoc.get().setAddress(doc.getAddress());
           updateDoc.get().setCnic(doc.getCnic());
           updateDoc.get().setFees(doc.getFees());
           updateDoc.get().setGender(doc.getGender());
           updateDoc.get().setSallary(doc.getSallary());
           updateDoc.get().setEmrNo(doc.getEmrNo());
           updateDoc.get().setEmail(doc.getEmail());
           updateDoc.get().setDateOfbirth(doc.getDateOfbirth());
           updateDoc.get().setDaysservice(doc.getDaysservice());
           updateDoc.get().setQualification(doc.getQualification());
           updateDoc.get().setNationality(doc.getNationality());
           updateDoc.get().setMobile(doc.getMobile());
           updateDoc.get().setSpeciality(doc.getSpeciality());
           updateDoc.get().setHoursday(doc.getHoursday());
           updateDoc.get().setPosition(doc.getPosition());
           updateDoc.get().setReligion(doc.getReligion());
           updateDoc.get().setTimeIn(doc.getTimeIn());
           updateDoc.get().setTimeOut(doc.getTimeOut());
            if (directory != null) {
                directory.setName(doc.getFullName());
                directory.setAddress(doc.getAddress());
                directory.setStatus("Active");
                directory.setErNo(doc.getEmrNo());
                directory.setNumber(doc.getMobile());
            }

           Doctor existingDoc = doctorRepository.save(updateDoc.get());
            if (existingDoc != null){
                directoryRepository.save(directory);
            }
           return "{\"UPDATED SUCCESFULLY\":1}";
       }
       else
       {
           return "{\"NoDoctorAvailablesWithThisID\":1}";
       }


    }

    public String delDoctor(){
        //listDoctor.clear();
        return "DELETED SUCCESSFULLY";
    }

//    Get Doctor by id will get only that doctor whose id is passed
  public Doctor getDocByID(Long mrNo){
      Optional<Doctor> doc= doctorRepository.findById(mrNo);
      if (doc.isPresent()) {
          return doc.get();
      }
      else {
          return  null;
      }

  }

}
