package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;

import java.util.List;
public interface IEnderecoService {

    List<EnderecoResponseDTO> getAll();

    EnderecoResponseDTO getById(Long id);

    EnderecoResponseDTO create(EnderecoRequestDTO enderecoRequest);

    EnderecoResponseDTO update(Long id, EnderecoRequestDTO enderecoRequest);

    void deleteById(Long id);

}
