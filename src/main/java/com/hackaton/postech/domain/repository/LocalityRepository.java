package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface LocalityRepository extends JpaRepository<Locality, Long>,
        JpaSpecificationExecutor<Locality> {

}
