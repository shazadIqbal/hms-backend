package com.example.test.Service;

        import com.example.test.DTO.BedDto;
        import com.example.test.Model.Bed;
        import com.example.test.Model.User;
        import com.example.test.Repository.BedRepository;
        import com.example.test.Repository.UserDao;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

@Service
public class BedService {

    @Autowired
    BedRepository bedRepository;

    //adding admission
    @Autowired
    UserDao userDao;

    public String createBed(BedDto bedDto){
         //LOOP for creating multiple objects of the beds of same type with dif id

        for(int i = 0; i < bedDto.getBedsQuantity(); i++){
            try{
                bedRepository.save(new Bed(bedDto.getBedType(), Boolean.FALSE , bedDto.getPrice(),username(),bedDto.getUpdatedBy(),bedDto.getUpdateAt(),new Date()));
            }catch(Exception e){
                System.out.println(e);
                return "{\"bed failed to create\":1}";
            }
        }
       return  "{\"bed successfully created\":1}";

    }

    public List<Bed> getBeds(){

        List<Bed> response = bedRepository.getAllAvailableBeds(Boolean.FALSE);

//        this.getSelectedBedType();
//        List<Bed> checkAdmisson = new ArrayList<>();
//        //it will return only those beds that are not occupied means false or 0
//        response.forEach(e->{
//            if(!e.isOccupied()){
//                checkAdmisson.add(e);
//            }
//        });

        return response;
    }

//    get only selectedBedType
public List<Bed> getSelectedBedType(String bedType){

    List<Bed> responseList = bedRepository.findBedsByBedTypeAndIsOccupied(bedType,Boolean.FALSE);
    return responseList;

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
