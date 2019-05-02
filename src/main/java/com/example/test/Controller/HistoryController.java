package com.example.test.Controller;


import com.example.test.DTO.RestTemplateResponseDTO;
import com.example.test.Model.History;
import com.example.test.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping("/{id}")
    public RestTemplateResponseDTO getDirectory(@PathVariable("id") Long id)
    {
        return historyService.getHistory(id);
    }



}
