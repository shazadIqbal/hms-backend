package com.example.test.Controller;

import com.example.test.DTO.FacilityDTO;
import com.example.test.Model.Facility;
import com.example.test.Service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/facility")
public class FacilityController {

    @Autowired
    FacilityService facilityService;

    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public String postFacility(@RequestBody FacilityDTO facilityDTO){
        return facilityService.postFacility(facilityDTO);
    }

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<Facility> getFacility(){
        return facilityService.getFacility();
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
        public Optional<Facility> getFacilityByID(@PathVariable("id") Long id){
        return facilityService.getFacilityById(id);
        }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public String deleteFacilityByID(@PathVariable("id") Long id){
        return facilityService.deleteFacilityById(id);
    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public String updateFacilityByID(@RequestBody FacilityDTO facilityDTO, @PathVariable("id") Long id){
        return facilityService.updateFacilityById(facilityDTO,id);
    }
}
