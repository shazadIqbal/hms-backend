package com.example.test.Repository;

import com.example.test.Model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectoryRepository extends JpaRepository<Directory,Long>{
        public  Directory findByNumber(String number);
}
