package com.example.test.Controller;

import com.example.test.DTO.DoctorDTO;
import com.example.test.DTO.PanelDTO;
import com.example.test.DTO.PanelFacilityDTO;
import com.example.test.Model.Panel;
import com.example.test.Model.PanelFacility;
import com.example.test.Repository.PanelRepository;
import com.example.test.Service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/panel")
public class PanelController {
    @Autowired
    PanelService panelService;

    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public String addNewPanel(@RequestBody PanelDTO panel ) {

        return this.panelService.savePanel(panel);
    }
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<Panel> getAllPanel(){

       return this.panelService.getAllPanel();

    }

    @GetMapping("/{id}")
    public Panel getPanelById(@PathVariable Long panelId){
        return this.panelService.getPanelById(panelId);
    }

    @DeleteMapping("/{id}")
    public List<Panel> deletePanelById(@PathVariable Long id){

        return this.panelService.deletePanelById(id);
    }
    @PostMapping("/panelfacility/")
    public String addNewFacility(@RequestBody PanelFacilityDTO facility ){
        return this.panelService.addNewFacility(facility);
    }
    @GetMapping("/panelfacility/")
    public List<PanelFacility> getAllFacility() {
        return this.panelService.getFacility();
    }





}
