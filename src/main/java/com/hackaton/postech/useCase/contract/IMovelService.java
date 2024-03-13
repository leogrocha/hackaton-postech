package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.domain.model.Movel;

import java.util.List;

public interface IMovelService {

    List<MovelResponseDTO> getAll();

    MovelResponseDTO getById(Long id);

    MovelResponseDTO create(MovelRequestDTO MovelRequest);

    MovelResponseDTO update(Long id, MovelRequestDTO MovelRequest);

    void deleteById(Long id);

    List<Movel> obterOuCriarMoveisPadrao(List<String> nomesMoveisPadrao);
}
