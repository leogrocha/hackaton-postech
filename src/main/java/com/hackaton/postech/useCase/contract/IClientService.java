package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;

import java.util.List;

public interface IClientService {

  List<ClienteResponseDTO> getAll();

  ClienteResponseDTO getById(Long id);

  ClienteResponseDTO create(ClienteResponseDTO clienteResponseDTO);

  ClienteResponseDTO update(Long id, ClienteResponseDTO clienteResponseDTO);

  void deleteById(Long id);
}
