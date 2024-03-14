package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.ReservaRequestDTO;
import com.hackaton.postech.domain.dto.response.ReservaResponseDTO;

import java.util.List;

public interface IReservaService {

  List<ReservaResponseDTO> getAll();

  ReservaResponseDTO getById(Long id);

  ReservaResponseDTO create(ReservaRequestDTO reservaRequestDTO);

  ReservaResponseDTO update(Long id, ReservaRequestDTO reservaRequestDTO);

  void deleteById(Long id);

}
