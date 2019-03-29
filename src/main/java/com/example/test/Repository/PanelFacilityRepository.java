package com.example.test.Repository;

import com.example.test.Model.Panel;
import com.example.test.Model.PanelFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PanelFacilityRepository extends JpaRepository<PanelFacility,Long> {

        public PanelFacility findByFacilityName(String facilityName);

}
