package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PredioRepository extends JpaRepository<Predio, Long>,
        JpaSpecificationExecutor<Predio> {

}
