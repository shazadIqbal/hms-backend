package com.example.test.Repository;


import com.example.test.Model.Patient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("patientRepository")
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(value = "select * from patient where gyn_and_obs_registration = TRUE AND status = 'ACTIVE' ",
            nativeQuery = true)
    public List<Patient> getAllGynyObsPatients();

    public Patient findByPhoneNo(String phoneNo);

    @Query(value= "select * from patient where date between  :from AND :till",nativeQuery = true)
    public List<Patient> getCountOfPatientByDate(@Param("from") String from,@Param("till") String till);

}
