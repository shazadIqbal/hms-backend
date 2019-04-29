package com.example.test.Repository;

import com.example.test.Model.PatientPackage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("packageRepository")
public interface PatientPackageRepository extends JpaRepository<PatientPackage, Long> {

}
