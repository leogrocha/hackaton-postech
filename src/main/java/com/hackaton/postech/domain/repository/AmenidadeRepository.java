package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Amenidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AmenidadeRepository extends JpaRepository<Amenidade, Long>,
        JpaSpecificationExecutor<Amenidade> {

}
