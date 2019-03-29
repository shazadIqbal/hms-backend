package com.example.test.Controller;


import com.example.test.DTO.LabtestCategoryDTO;
import com.example.test.DTO.LabtestDTO;
import com.example.test.Model.Labtest;
import com.example.test.Model.Labtestcategory;
import com.example.test.Service.LabtestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/labtest")

public class LabtestController {

    @Autowired
    LabtestService labtestService;

    @PostMapping("/category")
    public String postCategory(@RequestBody LabtestCategoryDTO labtestCategoryDTO){
        return labtestService.postCategory(labtestCategoryDTO);
    }

    @GetMapping("/category")
    public List<Labtestcategory> getcategory(){
        return labtestService.getCategory();
    }

    @PostMapping("/")
    public String postLabtest(@RequestBody LabtestDTO labtestDTO){
        return labtestService.postLabTest(labtestDTO);
    }

    @GetMapping("/")
    public List<Labtest> getlabtest(){
        return labtestService.getLabTest();
    }

    @DeleteMapping("/category/{id}")
    public List<Labtestcategory> delCategory(@PathVariable("id") Long id){
        return labtestService.delCategory(id);
    }

    @DeleteMapping("/{id}")
    public List<Labtest> delLabtest(@PathVariable("id") Long id){
        return labtestService.delLabTest(id);
    }



}
