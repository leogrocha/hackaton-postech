package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface LocalidadeRepository extends JpaRepository<Localidade, Long>,
        JpaSpecificationExecutor<Localidade> {

}
