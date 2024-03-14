package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IReservaController;
import com.hackaton.postech.domain.dto.request.ReservaRequestDTO;
import com.hackaton.postech.domain.dto.response.ReservaResponseDTO;
import com.hackaton.postech.useCase.contract.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/reservas")
public class ReservaController implements IReservaController {

  @Autowired
  private final IReservaService service;
  @Override
  public List<ReservaResponseDTO> getAll() {
    return service.getAll();
  }

  @Override
  public ReservaResponseDTO getById(Long id) {
    return service.getById(id);
  }

  @Override
  public ReservaResponseDTO create(ReservaRequestDTO reservaRequestDTO) {
    return service.create(reservaRequestDTO);
  }

  @Override
  public ReservaResponseDTO update(Long id, ReservaRequestDTO reservaRequestDTO) {
    return service.update(id, reservaRequestDTO);
  }

  @Override
  public void deleteById(Long id) {
    service.deleteById(id);
  }
}
