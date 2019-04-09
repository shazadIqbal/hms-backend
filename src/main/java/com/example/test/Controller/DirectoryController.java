package com.example.test.Controller;


import com.example.test.DTO.DirectoryDTO;
import com.example.test.Model.Directory;
import com.example.test.Service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/directory")
public class DirectoryController {


    @Autowired
    DirectoryService directoryService;


    @PostMapping("/")
    public String postDirectory(@RequestBody DirectoryDTO directoryDTO)
    {
      return   directoryService.postDirectory(directoryDTO);
    }

    @GetMapping("/")
    public List<Directory> getDirectory()
    {
        return directoryService.getDirectory();
    }

    @DeleteMapping("/{id}")
    public List<Directory> deleteDirectory(@PathVariable("id") Long id )
    {
        return directoryService.deleteDirectory(id);
    }

}
