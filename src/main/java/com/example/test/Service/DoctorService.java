package com.example.test.Service;


import com.example.test.DTO.AccountRestDTO;
import com.example.test.DTO.DoctorDTO;
import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.Directory;
import com.example.test.Model.Doctor;
import com.example.test.Model.User;
import com.example.test.Repository.DirectoryRepository;
import com.example.test.Repository.DoctorRepository;
import com.example.test.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import java.util.*;

//import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

@Service
public class DoctorService {
    // List listDoctor=new ArrayList<>();

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DirectoryRepository directoryRepository;
    @Value("${account.url}")
    public String url;

    @Autowired
    UserDao userDao;

    @Transient
    private UUID corrId;

    RestTemplate restTemplate = new RestTemplate();

    public List<Doctor> getDoctors() {
        List<Doctor> list = doctorRepository.getAllDoctors();
//        List<Doctor> responseList = new ArrayList<>();
//        list.forEach(doctors -> {
//            Doctor doctor = new Doctor();
//            doctor.setMrno(doctor.getMrno());
//            doctor.setFullName(doctor.getFullName());
//            doctor.setEmail(doctor.getEmail());
//            doctor.setAddress(doctor.getAddress());
//            doctor.setCreatedDate(doctor.getCreatedDate());
//            doctor.setCnic(doctor.getCnic());
//            doctor.setGender(doctor.getGender());
//            doctor.setSallary(doctor.getSallary());
//            doctor.setFees(doctor.getFees());
//            doctor.setMobile(doctor.getMobile());
//            doctor.setEmrNo(doctor.getEmrNo());
//            doctor.setAddress(doctor.getAddress());
//            doctor.setDateOfbirth(doctor.getDateOfbirth());
//            doctor.setNationality(doctor.getNationality());
////            doctorDto.setQualification(doctor.getQualification());
//            doctor.setReligion(doctor.getReligion());
//            doctor.setHoursday(doctor.getHoursday());
//            doctor.setHoursday(doctor.getHoursday());
//            doctor.setDaysservice(doctor.getDaysservice());
//            doctor.setPosition(doctor.getPosition());
//            doctor.setDateOfbirth(doctor.getDateOfbirth());
//            doctor.setTimeIn(doctor.getTimeIn());
//            doctor.setTimeOut(doctor.getTimeOut());
//            doctor.setQualification(doctor.getQualification());
//            doctor.setAccountNo(doctor.getAccountNo());
//            doctor.setShare(doctor.getShare());
//            responseList.add(doctors);
//        });
        return list;
    }

    public List<Doctor> getInactiveDoctors() {
        List<Doctor> list = doctorRepository.getAllInactiveDoctors();
        return list;
    }

    public String postDoctorFromService(DoctorDTO doc) {


        Doctor doctor = new Doctor();
        doctor.setCreatedDate(new Date());
        doctor.setCreatedBy(username());
        Directory directory = new Directory();
        AccountRestDTO accountRestDTO = new AccountRestDTO();

//        Prevent Same Records
        Doctor findDoctorByMobileNo = doctorRepository.findByMobile(doc.getMobile());
//        when saving a doctor no two doctors can have the same mobile no so when saving
//        you must check whether the mobile number is already present or not
//        if already present than doctorCanNotAdd else Add this new doctor
        try {
            if (findDoctorByMobileNo == null) {
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
                doctor.setSpeciality(doc.getSpeciality());
                doctor.setHoursday(doc.getHoursday());
                doctor.setTimeIn(doc.getTimeIn());
                doctor.setTimeOut(doc.getTimeOut());
                doctor.setQualification(doc.getQualification());
                doctor.setShare(doc.getShare());
                doctor.setStatus("Active");
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
                RestTemplateResponseDTO result = restTemplate.postForObject(url, accountRestDTO, RestTemplateResponseDTO.class);

            } else {
                return "{\"CAN NOT ADD DUPLICATE RECORD\"WARN\":1}";
            }
        }catch (Exception e){
            System.out.println(e);
            return "{\"CAN NOT ADD DUPLICATE RECORD\"Warn\":1}";
        }
        return "{\"ADDED SUCCESFULLY\":1}";
    }

    public String updateDoctorFromService(Long mrNo,String mobile,DoctorDTO doc){
        Doctor doctor = new Doctor();
        Optional<Doctor> updateDoc = doctorRepository.findById(mrNo);
        Directory directory = directoryRepository.findByNumber(mobile);
//

        if(updateDoc.isPresent()){
            updateDoc.get();
//           Directory diretoryObj =new Directory();
            updateDoc.get().setFullName(doc.getFullName());
            updateDoc.get().setCreatedDate(new Date());
            updateDoc.get().setAddress(doc.getAddress());
            updateDoc.get().setCnic(doc.getCnic());
            updateDoc.get().setUpdateAt(new Date());
            updateDoc.get().setUpdatedBy(username());
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
            updateDoc.get().setShare(doc.getShare());
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

    public List<Doctor> delDoctor(Long mrNo){
        Optional<Doctor> response = doctorRepository.findById(mrNo);
        if(response.isPresent()) {
            Doctor doctor = response.get();
            doctor.setStatus("Inactive");
            doctorRepository.save(doctor);
            return getDoctors();
        }else {
            return null;
        }
        //listDoctor.clear();
    }

    public List<Doctor> activeDoctor(Long mrNo) {
        Optional<Doctor> response = doctorRepository.findById(mrNo);
        if (response.isPresent()) {
            Doctor doctor = response.get();
            doctor.setStatus("ACTIVE");
            doctorRepository.save(doctor);
            return getDoctors();
        } else {
            return null;
        }
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

    public String username()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDao.findByEmail(username);

        return  user.getName();

    }
}