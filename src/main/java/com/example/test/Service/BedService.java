package com.example.test.Service;

        import com.example.test.DTO.BedDto;
        import com.example.test.Model.Bed;
        import com.example.test.Repository.BedRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;

@Service
public class BedService {

    @Autowired
    BedRepository bedRepository;

    //adding admission
    public String createBed(BedDto bedDto){
         //LOOP for creating multiple objects of the beds of same type with dif id
        for(int i = 0; i < bedDto.getBedsQuantity(); i++){
            try{
                bedRepository.save(new Bed(bedDto.getBedType(), Boolean.FALSE , bedDto.getPrice(),bedDto.getCreatedBy(),bedDto.getUpdatedBy(),bedDto.getUpdateAt(),bedDto.getCreatedAt()));
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



}
