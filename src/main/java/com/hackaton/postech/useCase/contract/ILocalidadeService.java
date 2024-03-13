package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;

import java.util.List;

public interface ILocalidadeService {

    List<LocalidadeResponseDTO> getAll();

    LocalidadeResponseDTO getById(Long id);

    LocalidadeResponseDTO create(LocalidadeRequestDTO localidadeRequest);

    LocalidadeResponseDTO update(Long id, LocalidadeRequestDTO localidadeRequest);

    void deleteById(Long id);
}
