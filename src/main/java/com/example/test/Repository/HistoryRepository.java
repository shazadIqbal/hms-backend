package com.example.test.Repository;


import com.example.test.Model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long>
{
    public List<History> findByPatientId(Long id);
}
