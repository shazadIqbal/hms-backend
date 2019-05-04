package com.example.test.Controller;

import com.example.test.DTO.BedDto;
import com.example.test.Model.Bed;
import com.example.test.Service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/bed")
public class BedController {

    @Autowired
    BedService bedService;

    @PostMapping("/")
    public String createBeds(@RequestBody BedDto bedDto){
        return  bedService.createBed(bedDto);
    }

    @GetMapping("/")
    public List<Bed> getBeds(){
        return  this.bedService.getBeds();
    }

    @GetMapping("/selectbedtype/{bedType}")
    public List<Bed> getSelectedBeds(@PathVariable ("bedType") String bedType){

        return this.bedService.getSelectedBedType(bedType);

    }
}
