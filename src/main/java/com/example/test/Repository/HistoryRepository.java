package com.example.test.Repository;


import com.example.test.Model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long>
{

}
