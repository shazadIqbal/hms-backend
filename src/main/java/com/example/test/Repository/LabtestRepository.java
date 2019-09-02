package com.example.test.Repository;


import com.example.test.Model.Labtest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("labtestRepository")
public interface LabtestRepository extends JpaRepository<Labtest, Long>{

    @Query(value = "select * from labtest where status = 'ACTIVE' ", nativeQuery = true)
    public List<Labtest> getAllLabTests();

}
