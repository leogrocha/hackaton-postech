package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;

import java.util.List;

public interface IPredioService {

    List<PredioResponseDTO> getAll();

    PredioResponseDTO getById(Long id);

    PredioResponseDTO create(PredioRequestDTO predioRequest);

    PredioResponseDTO update(Long id, PredioRequestDTO predioRequest);

    void deleteById(Long id);
}
