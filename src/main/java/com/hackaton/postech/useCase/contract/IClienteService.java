package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;

import java.util.List;

public interface IClienteService {

  List<ClienteResponseDTO> getAll();

  ClienteResponseDTO getById(Long id);

  ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO);

  ClienteResponseDTO update(Long id, ClienteRequestDTO clienteRequestDTO);

  void deleteById(Long id);
}
