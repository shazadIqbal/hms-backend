package com.example.test.Repository;

import com.example.test.Model.Bed;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("bedRepository")
public interface BedRepository extends JpaRepository<Bed,Long> {

    @Query(value = "select * from bed where is_occupied = :occupied",
            nativeQuery = true)
    public List<Bed> getAllAvailableBeds(@Param("occupied") Boolean occupied);

    public List<Bed> findBedsByBedType(String bedType);

    public List<Bed> findBedsByBedTypeAndIsOccupied(String bedType,Boolean isOccupied);

}
