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

    @PostMapping("/{id}")
    public String addHistory(@PathVariable("id") Long id)
    {
        return historyService.addHistory(id);
    }



}
