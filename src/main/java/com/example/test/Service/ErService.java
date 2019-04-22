package com.example.test.Service;

import com.example.test.DTO.ErDTO;
import com.example.test.Model.Er;
import com.example.test.Repository.ErRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ErService {
    @Autowired
    ErRepository erRepository;
    public String postEr(ErDTO erDTO){
        Er er = new Er();
        er.setName(erDTO.getName());
        er.setResources(erDTO.getResources());
        er.setPrice(erDTO.getPrice());
        er.setExtraCharges(erDTO.getExtraCharges());
        er.setTotal(erDTO.getTotal());
        er.setStatus("Active");
        er.setFacilities(erDTO.getFacilities());
        erRepository.save(er);
        return "{\"ADDED SUCCESFULLY\":1}";
    }
    public List<Er> getEr(){
        List<Er> er = erRepository.findAll();
        List<Er> activeEr = new ArrayList<>();
        er.forEach(ers ->{
            if(ers.getStatus().equalsIgnoreCase("Active")){
                activeEr.add(ers);
            }
        });
        return activeEr;
    }

    public String updateErByID(ErDTO er, Long id){
        Optional<Er> ers = erRepository.findById(id);
        if(ers.isPresent()){
            Er _er = ers.get();
            _er.setName(er.getName());
            _er.setResources(er.getResources());
            _er.setPrice(er.getPrice());
            _er.setExtraCharges(er.getExtraCharges());
            _er.setTotal(er.getTotal());
            _er.setStatus(er.getStatus());
            _er.setFacilities(er.getFacilities());
            erRepository.save(_er);
        }
        return "{\"UPDATED SUCCESFULLY\":1}";
    }
    public String deleteErById(Long id){
        Optional<Er> er = erRepository.findById(id);
        if(er.isPresent()){
            Er deleteEr = er.get();
            deleteEr.setStatus("Inactive");
            erRepository.save(deleteEr);
        }
        return "{\"DELETED SUCCESFULLY\":1}";
    }

    public Optional<Er> getErById(Long id){
        Optional<Er> er = erRepository.findById(id);
        return er;
    }

}