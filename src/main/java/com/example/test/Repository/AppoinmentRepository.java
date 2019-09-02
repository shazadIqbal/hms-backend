package com.example.test.Repository;

import com.example.test.Model.Appoinment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
@Qualifier("appoinmentRepository")
public interface AppoinmentRepository extends JpaRepository<Appoinment,Long> {

    @Query(value = "select * from appoinment where DATE(appoinment_date) = :appoinmentDate",
            nativeQuery = true)
    public List<Appoinment> findByAppoinmentDate(@Param("appoinmentDate") String appoinmentDate );

    public List<Appoinment> findByStatus(String status);

    @Query(value = "select * from appoinment where status = 'ACTIVE'" , nativeQuery = true)
    public List<Appoinment> getAllAppoinments();
}
