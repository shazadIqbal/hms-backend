package com.example.test.Service;

import com.example.test.DTO.DirectoryDTO;
import com.example.test.Model.Directory;
import com.example.test.Model.Doctor;
import com.example.test.Repository.DirectoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DirectoryService {

    @Autowired
    DirectoryRepository directoryRepository;


    public String postDirectory(DirectoryDTO directoryDto) {
        Directory directory = new Directory();
        directory.setName(directoryDto.getName());
        directory.setNumber(directoryDto.getNumber());
        directory.setAddress(directoryDto.getAddress());
        directory.setErNo(directoryDto.getErNo());
        directory.setStatus("Active");

        directoryRepository.save(directory);


        return "{\"Record added successfully\":1}";
    }

    public List<Directory> getDirectory() {
        List<Directory>  response= directoryRepository.findAll();
        List<Directory> data=new ArrayList<>();

        response.forEach(v->{
            if(v.getStatus().equalsIgnoreCase("Active"))
            {
                data.add(v);
            }
        });


        return data;

    }

    public List<Directory> deleteDirectory(Long id)
    {
        Optional<Directory> response=directoryRepository.findById(id);
                if(response.isPresent())
                {
                    Directory directory=response.get();
                    directory.setStatus("Inactive");
                    directoryRepository.save(directory);

                    return getDirectory();

                }
                else
                {

                    return null;
                }
    }

}
