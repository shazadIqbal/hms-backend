package com.example.test.Repository;

import com.example.test.Model.PatientPackage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("packageRepository")
public interface PatientPackageRepository extends JpaRepository<PatientPackage, Long> {

    @Query(value = "select * from patient_package where status = 'ACTIVE' ", nativeQuery = true)
    public List<PatientPackage> getAllPakages();

}
