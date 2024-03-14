package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Amenities;
import com.hackaton.postech.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>,
    JpaSpecificationExecutor<Client> {
}
