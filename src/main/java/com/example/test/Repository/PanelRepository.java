package com.example.test.Repository;

import com.example.test.Model.Panel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("panelRepository")
public interface PanelRepository extends JpaRepository<Panel,Long> {


}
