package com.hackaton.postech.domain.repository;

import com.hackaton.postech.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoomRepository extends JpaRepository<Room, Long>,
        JpaSpecificationExecutor<Room> {

}
