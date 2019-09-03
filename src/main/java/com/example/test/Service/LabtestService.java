package com.example.test.Service;

import com.example.test.DTO.LabtestCategoryDTO;
import com.example.test.DTO.LabtestDTO;
import com.example.test.Model.Labtest;
import com.example.test.Model.Labtestcategory;
import com.example.test.Model.User;
import com.example.test.Repository.LabtestRepository;
import com.example.test.Repository.LabtestCategoryRepository;
import com.example.test.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LabtestService {

    @Autowired
    LabtestCategoryRepository labtestCategoryRepository;

    @Autowired
    LabtestRepository labtestRepository;

    @Autowired
    UserDao userDao;

    public String postCategory(LabtestCategoryDTO labtestCategoryDTO){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDao.findByEmail(username);

        Labtestcategory labtestcategory=labtestCategoryRepository.findByCategory(labtestCategoryDTO.getCategory());
        if(labtestcategory != null){
            return   "{\"Already exsist\":1}";
        }else{
            Labtestcategory lab = new Labtestcategory();
            lab.setCategory(labtestCategoryDTO.getCategory());
            lab.setCreatedDate(new Date());
            lab.setStatus("ACTIVE");
            lab.setCreatedAt(new Date());
            lab.setCreatedBy(user.getName());

            labtestCategoryRepository.save(lab);
            return "{\"Lab Test Category added successfully\":1}";
        }
    }

    public List<Labtestcategory> getCategory(){
        List<Labtestcategory> list = labtestCategoryRepository.getAllLabCat();
//        List<Labtestcategory> listFiltered=new ArrayList();
//        list.forEach(c->{
//            if(c.getStatus().equalsIgnoreCase("ACTIVE"))
//            {
//                listFiltered.add(c);
//            }
//        });
        return list;
    }

    public String postLabTest(LabtestDTO labtestDTO){


        Labtest labtest = new Labtest();
        labtest.setCategory(labtestDTO.getCategory());
        labtest.setName(labtestDTO.getName());
        labtest.setDetails(labtestDTO.getDetails());
        labtest.setPrice(labtestDTO.getPrice());
        labtest.setCreatedDate(new Date());
        labtest.setCreatedBy(username());
        labtest.setCreatedDate(new Date());
        labtest.setStatus("ACTIVE");
        labtestRepository.save(labtest);
        return "{\"Labtest added successfully\":1}";
    }

    public List<Labtest> getLabTest() {
        List<Labtest> list = labtestRepository.getAllLabTests();
//        List<Labtest> listFiltered = new ArrayList<>();
//        list.forEach(i -> {
//            if (i.getStatus().equalsIgnoreCase("ACTIVE")){
//                listFiltered.add(i);
//            }
//        });
        return list;
    }

    public List<Labtest> delLabTest(Long id) {
        Optional<Labtest> labtest = labtestRepository.findById(id);
        if (labtest.isPresent()){
            Labtest lt = labtest.get();
            lt.setStatus("INACTIVE");
            labtestRepository.save(lt);
            return getLabTest();
        }
        else {
            String a[] = new String[]{"Not Found"};
            List list = Arrays.asList(a);
            return list;
        }
    }

    public List<Labtestcategory> delCategory(Long id){
        Optional<Labtestcategory> labtestcategory = labtestCategoryRepository.findById(id);
        if (labtestcategory.isPresent()){
            Labtestcategory ltc = labtestcategory.get();
            ltc.setStatus("INACTIVE");
            labtestCategoryRepository.save(ltc);
            return getCategory();
        }
        else {
            return null;
        }

    }

    public String username()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDao.findByEmail(username);

        return  user.getName();

    }
}
