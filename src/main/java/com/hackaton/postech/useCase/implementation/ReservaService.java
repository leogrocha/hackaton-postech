package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.ReservaMapper;
import com.hackaton.postech.domain.dto.request.ReservaRequestDTO;
import com.hackaton.postech.domain.dto.response.ReservaResponseDTO;
import com.hackaton.postech.domain.model.Cliente;
import com.hackaton.postech.domain.model.Reserva;
import com.hackaton.postech.domain.repository.ReservaRepository;
import com.hackaton.postech.useCase.contract.IReservaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService {

  @Autowired
  private final ReservaRepository repository;

  @Autowired
  private final ReservaMapper reservaMapper;
  @Override
  public List<ReservaResponseDTO> getAll() {
    return repository.findAll()
        .stream()
        .map(reservaMapper::convertToReservaResponse)
        .toList();
  }

  @Override
  public ReservaResponseDTO getById(Long id) {
    return reservaMapper.convertToReservaResponse(findByIdReserva(id));
  }

  @Override
  public ReservaResponseDTO create(ReservaRequestDTO reservaRequestDTO) {
    return null;
  }

  @Override
  public ReservaResponseDTO update(Long id, ReservaRequestDTO reservaRequestDTO) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }

  private Reserva findByIdReserva(Long reservaId) {
    return repository.findById(reservaId)
        .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado na base de dados."));
  }
}
