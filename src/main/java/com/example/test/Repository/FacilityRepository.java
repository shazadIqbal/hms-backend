package com.example.test.Repository;


import com.example.test.Model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility,Long> {

    @Query(value = "select * from facility where status = 'ACTIVE' ", nativeQuery = true)
    public List<Facility> getAllFacilities();

}
