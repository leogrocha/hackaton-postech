package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.model.Quarto;

import java.util.List;

public interface IQuartoService {

    List<QuartoResponseDTO> getAll();

    QuartoResponseDTO getById(Long id);

    QuartoResponseDTO create(QuartoRequestDTO quartoRequest);

    QuartoResponseDTO update(Long id, QuartoRequestDTO quartoRequest);

    void deleteById(Long id);

}
