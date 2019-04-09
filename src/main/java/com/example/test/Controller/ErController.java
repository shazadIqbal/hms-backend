package com.example.test.Controller;

import com.example.test.DTO.ErDTO;
import com.example.test.Model.Er;
import com.example.test.Service.ErService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/er")
public class ErController {

    @Autowired
    ErService erService;

    @RequestMapping(value = "/" ,method = RequestMethod.POST)
    public String postEr(@RequestBody ErDTO erDTO){
        return erService.postEr(erDTO);
    }

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public List<Er> getEr(){
        return erService.getEr();
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public Optional<Er> getErByID(@PathVariable("id") Long id){
        return erService.getErById(id);
    }
//    //@RequestMapping(value = "/facility" ,method = RequestMethod.PUT)
//    public Optional<Er> getErById(@RequestBody ErDTO er){
//        return erService.getErByID(14l,er);
//    }
        @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT,consumes = "application/json")
        public String updateEr(@RequestBody ErDTO erDto, @PathVariable("id") Long id){
        return erService.updateErByID(erDto, id);
}
    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public String deleteErByID(@PathVariable("id") Long id){
        return erService.deleteErById(id);
    }

}
