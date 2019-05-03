package com.example.test.Controller;


import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.History;
import com.example.test.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping("addhistory/{id}")
    public String addPatientHistory(@PathVariable("id") Long id)
    {
        return historyService.addPatientHistory(id);
    }


    @GetMapping("gethistory/{id}")
    public List<History> getPatientHistory(@PathVariable("id") Long id){
        return historyService.getPatientHistory(id);
    }



}
