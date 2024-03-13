package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;

import java.util.List;

public interface IAmenidadeService {

    List<AmenidadeResponseDTO> getAll();

    AmenidadeResponseDTO getById(Long id);

    AmenidadeResponseDTO create(AmenidadeRequestDTO amenidadeRequest);

    AmenidadeResponseDTO update(Long id, AmenidadeRequestDTO amenidadeRequest);

    void deleteById(Long id);
}
