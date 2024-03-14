package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Amenidade;
import com.hackaton.postech.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>,
    JpaSpecificationExecutor<Cliente> {
}
