package com.example.test.Service;

import com.example.test.DTO.PatientPackageDTO;
import com.example.test.Model.PatientPackage;
import com.example.test.Model.User;
import com.example.test.Repository.PatientPackageRepository;
import com.example.test.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientPackageService {

    @Autowired
    PatientPackageRepository patientPackageRepository;

    @Autowired
    UserDao userDao;

    public List<PatientPackage> getPackages() {
        List<PatientPackage> list = patientPackageRepository.findAll();
        List<PatientPackage> responseList = new ArrayList<>();
        list.forEach(patientPackage -> {
            if(patientPackage.getStatus().equalsIgnoreCase("Active")){
                responseList.add(patientPackage);
            }
        });
        return responseList;
    }

    public String postPackage(PatientPackageDTO pack) {
        PatientPackage patientPackage = new PatientPackage();
        patientPackage.setpName(pack.getpName());
        patientPackage.setpFacility(pack.getpFacility());
        patientPackage.setpStartDate(pack.getpStartDate());
        patientPackage.setpEndDate(pack.getpEndDate());
        patientPackage.setpSponsor(pack.getpSponsor());
        patientPackage.setpPrice(pack.getpPrice());
        patientPackage.setCreatedAt(new Date());
        patientPackage.setCreatedBy(username());
        patientPackage.setStatus("Active");
        patientPackageRepository.save(patientPackage);
        return "{\"ADDED SUCCESFULLY\":1}";
    }


    public List<PatientPackage> deletePackageById(Long id) {
        Optional<PatientPackage> patientPackage = patientPackageRepository.findById(id);
        if (patientPackage.isPresent()){
            PatientPackage packagedel = patientPackage.get();
            packagedel.setStatus("Inactive");
            patientPackageRepository.save(packagedel);
        }
        return this.getPackages();
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
