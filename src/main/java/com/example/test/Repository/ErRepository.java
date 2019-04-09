package com.example.test.Repository;


import com.example.test.Model.Er;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("erRepository")
public interface ErRepository extends JpaRepository<Er,Long> {
}
