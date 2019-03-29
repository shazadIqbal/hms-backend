package com.example.test.Repository;


import com.example.test.Model.Patient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("patientRepository")
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
