package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import com.hackaton.postech.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IClientService {

  Page<ClientResponseDTO> findAll(PageRequest pageRequest);

  ClientResponseDTO findById(Long clientId);

  ClientResponseDTO save(ClientRequestDTO clientRequestDTO);

  ClientResponseDTO update(Long clientId, ClientRequestDTO clientRequestDTO);

  void deleteById(Long clientId);

}
