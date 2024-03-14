package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.RoomRequestDTO;
import com.hackaton.postech.domain.dto.response.RoomResponseDTO;

import java.util.List;

public interface IRoomService {

    List<RoomResponseDTO> getAll();

    RoomResponseDTO getById(Long id);

    RoomResponseDTO create(RoomRequestDTO roomRequestDTO);

    RoomResponseDTO update(Long id, RoomRequestDTO roomRequestDTO);

    void deleteById(Long id);

}
