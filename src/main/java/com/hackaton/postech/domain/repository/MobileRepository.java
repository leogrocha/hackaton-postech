package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface MobileRepository extends JpaRepository<Mobile, Long>,
        JpaSpecificationExecutor<Mobile> {

    Optional<Mobile> findByDescription(String description);
}
