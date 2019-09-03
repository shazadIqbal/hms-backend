package com.example.test.Service;

import com.example.test.DTO.DoctorDTO;
import com.example.test.DTO.PanelDTO;
import com.example.test.DTO.PanelFacilityDTO;
import com.example.test.Model.Facility;
import com.example.test.Model.Panel;
import com.example.test.Model.PanelFacility;
import com.example.test.Model.User;
import com.example.test.Repository.PanelFacilityRepository;
import com.example.test.Repository.PanelRepository;
import com.example.test.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanelService {

    @Autowired
    PanelRepository panelRepository;
    @Autowired
    PanelFacilityRepository facilityRepository;

    @Autowired
    UserDao userDao;


            public List<Panel>deletePanelById(Long id){
                // find this panelid from repository
                Panel panel= panelRepository.getOne(id);
                panel.setStatus("INACTIVE");
                panelRepository.save(panel);

                List<Panel> responseList = getAllPanel();



                return responseList;





                // using Panel panel = panelRepository.findOne(id)
                //panel.setStatus("InActive")
                //panelRepository.save(panel)

            }

            public Panel getPanelById(Long panelId) {
                //Panel findPanelById = panelRepository.findOne(panelId);
               Panel panel = panelRepository.getOne(panelId);
               if(panel != null){
                   return panel;

               }
               else{
                    return  null;
               }
                // find this panelid form repository
                // Panel panel= panelrepository.findone(panelid)
               //return panel



            }
            public String savePanel(PanelDTO panel ){
                Panel panelsave= new Panel();
                panelsave.setPanelName(panel.getPanelName());
                panelsave.setPanelType(panel.getPanelType());
                panelsave.setPanelFacility(panel.getPanelFacility());
                String startDate=panel.getPanelStartDate().substring(0,10);
                String endDate=panel.getPanelStartDate().substring(0,10);
                panelsave.setCreatedAt(new Date());
                panelsave.setCreatedBy(username());
                panelsave.setPanelStartDate(startDate);
                panelsave.setPanelEndDate(endDate);
                panelsave.setStatus("ACTIVE");
                panelsave.setDate(new Date());
                panelRepository.save(panelsave);
                return "added successfully";

            }
            public List<Panel> getAllPanel(){
                List<Panel> list = panelRepository.getAllPanels();
//                List<Panel>  responseList = new ArrayList<>();
//
//                for(Panel p : list){
//                    if(p.getStatus().equalsIgnoreCase("ACTIVE")){
//                        responseList.add(p);
//                    }
//                }
                return list;
            }

            public String addNewFacility(PanelFacilityDTO facility ){

               PanelFacility panelFacility = facilityRepository.findByFacilityName(facility.getFacilityName());
                if(panelFacility != null){
                    return  "{\"Already Exsist\":1}";
                }else{
                    PanelFacility newFacility = new PanelFacility();
                    newFacility.setCreatedAt(new Date());
                    newFacility.setCreatedBy(username());
                    newFacility.setFacilityName(facility.getFacilityName());
                    newFacility.setStatus("ACTIVE");
                    newFacility.setDate(new Date());
                    facilityRepository.save(newFacility);


                }
                return "{\"Successfully Added\":1}";


            }
             public  List <PanelFacility> getFacility(){
               List< PanelFacility> facility=facilityRepository.getAllPanelFacilities();
//               List<PanelFacility> responceList =  new ArrayList<>();
//                 for(PanelFacility f : facility){
//                     if(f.getStatus().equalsIgnoreCase("ACTIVE")){
//                         responceList.add(f);
//                     }
//                 }
                 return facility;
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