package com.example.test.Service;

import com.example.test.DTO.FacilityDTO;
import com.example.test.DTO.PanelFacilityDTO;
import com.example.test.Model.Facility;
import com.example.test.Model.User;
import com.example.test.Repository.FacilityRepository;
import com.example.test.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FacilityService {
    @Autowired
    FacilityRepository facilityRepository;


    @Autowired
    UserDao userDao;
    //Insert Facility into Database
    public String postFacility(FacilityDTO facilityDto){

        Facility facility = new Facility();
        facility.setName(facilityDto.getName());
        facility.setPrice(facilityDto.getPrice());
        facility.setStatus("Active");
        facility.setCreatedAt(new Date());
        facility.setCreatedBy(username());
        facilityRepository.save(facility);
        return "{\"ADDED SUCCESFULLY\":1}";
    }

    public List<Facility> getFacility(){
        List<Facility> facilities = facilityRepository.findAll();
        List<Facility> activeFacilities = new ArrayList<>();
        facilities.forEach(facility -> {
            if(facility.getStatus().equalsIgnoreCase("Active")){
                activeFacilities.add(facility);
            }
        });
        return activeFacilities;
    }
    public String deleteFacilityById(Long id){
        Optional<Facility> facility = facilityRepository.findById(id);
        if(facility.isPresent()){
            Facility deleteFacility = facility.get();
            deleteFacility.setStatus("Inactive");
            facilityRepository.save(deleteFacility);
        }
        return "{\"DELETED SUCCESFULLY\":1}";
    }
    public String updateFacilityById(FacilityDTO facilityDTO, Long id){
        Optional<Facility> facility = facilityRepository.findById(id);
        if(facility.isPresent()){
            Facility _facility = facility.get();
            _facility.setName(facilityDTO.getName());
            _facility.setPrice(facilityDTO.getPrice());
            _facility.setStatus(facilityDTO.getStatus());
            facilityRepository.save(_facility);
        }

        return "{\"UPDATED SUCCESFULLY\":1}";
    }
    public Optional<Facility> getFacilityById(Long id){
        Optional<Facility> facility = facilityRepository.findById(id);
        return facility;
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
