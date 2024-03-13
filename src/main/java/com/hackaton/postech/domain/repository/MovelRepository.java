package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Movel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface MovelRepository extends JpaRepository<Movel, Long>,
        JpaSpecificationExecutor<Movel> {

    Optional<Movel> findByDescricao(String descricao);
}
