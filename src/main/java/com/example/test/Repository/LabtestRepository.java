package com.example.test.Repository;


import com.example.test.Model.Labtest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("labtestRepository")
public interface LabtestRepository extends JpaRepository<Labtest, Long>{

}
