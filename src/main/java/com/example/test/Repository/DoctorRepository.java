package com.example.test.Repository;


import com.example.test.Model.Directory;
import com.example.test.Model.Doctor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    public Doctor findByMobile(String mobile);

    @Query(value = "select * from doctor where status= 'ACTIVE' ", nativeQuery = true)
    public List<Doctor> getAllDoctors();

}
