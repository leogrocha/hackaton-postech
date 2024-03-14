package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IClienteController;
import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.useCase.contract.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/clientes")
public class ClienteController implements IClienteController {

  @Autowired
  private final IClienteService service;

  @Override
  public List<ClienteResponseDTO> getAll() {
    return service.getAll();
  }

  @Override
  public ClienteResponseDTO getById(Long id) {
    return service.getById(id);
  }

  @Override
  public ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO) {
    return service.create(clienteRequestDTO);
  }

  @Override
  public ClienteResponseDTO update(Long id, ClienteRequestDTO clienteRequestDTO) {
    return service.update(id, clienteRequestDTO);
  }

  @Override
  public void deleteById(Long id) {
    service.deleteById(id);
  }
}
