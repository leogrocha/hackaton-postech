package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>,
        JpaSpecificationExecutor<Endereco> {
}