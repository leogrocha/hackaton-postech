package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface QuartoRepository extends JpaRepository<Quarto, Long>,
        JpaSpecificationExecutor<Quarto> {

}
