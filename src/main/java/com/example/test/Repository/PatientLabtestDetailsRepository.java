package com.example.test.Repository;

import com.example.test.Model.PatientLabtestDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("patientLabtestDetailsRepository")
public interface PatientLabtestDetailsRepository extends JpaRepository<PatientLabtestDetails,Long>{

}
