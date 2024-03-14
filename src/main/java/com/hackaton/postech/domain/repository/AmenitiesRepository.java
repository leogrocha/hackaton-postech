package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AmenitiesRepository extends JpaRepository<Amenities, Long>,
        JpaSpecificationExecutor<Amenities> {

}
