package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BuildingRepository extends JpaRepository<Building, Long>,
        JpaSpecificationExecutor<Building> {

}
