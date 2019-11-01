package com.example.test.Repository;

import com.example.test.Model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectoryRepository extends JpaRepository<Directory,Long>{
        public Directory findByNumber(String number);

        @Query(value = "select * from directory where status = 'ACTIVE' ", nativeQuery = true)
        public List<Directory> getAllDoctors();
}

