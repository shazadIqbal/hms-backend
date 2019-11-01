package com.example.test.Repository;

import com.example.test.Model.Panel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("panelRepository")
public interface PanelRepository extends JpaRepository<Panel,Long> {

    @Query(value = "select * from panel where status = 'ACTIVE' ", nativeQuery = true)
    public List<Panel> getAllPanels();

    Panel findByPanelName(String panelName);

}
