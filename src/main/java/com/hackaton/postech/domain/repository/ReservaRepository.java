package com.hackaton.postech.domain.repository;


import com.hackaton.postech.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReservaRepository extends JpaRepository<Reserva, Long>,
    JpaSpecificationExecutor<Reserva> {
}
