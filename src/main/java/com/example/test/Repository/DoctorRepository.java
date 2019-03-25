package com.example.test.Repository;


import com.example.test.Model.Doctor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
