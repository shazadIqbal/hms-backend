package com.example.test.Repository;


import com.example.test.Model.Er;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@Qualifier("erRepository")
public interface ErRepository extends JpaRepository<Er,Long> {

    @Query(value = "select * from er where status = 'ACTIVE' ", nativeQuery = true)
    public List<Er> getAllEr();

}
