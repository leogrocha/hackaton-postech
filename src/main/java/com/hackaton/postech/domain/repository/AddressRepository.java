package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Address;
import com.hackaton.postech.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address, Long>,
    JpaSpecificationExecutor<Address> {
}
