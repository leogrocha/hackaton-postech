package com.hackaton.postech.useCase;

import com.hackaton.postech.application.mapper.ReservaMapper;
import com.hackaton.postech.domain.dto.request.ReservaRequestDTO;
import com.hackaton.postech.domain.dto.response.ReservaResponseDTO;
import com.hackaton.postech.domain.model.Reserva;
import com.hackaton.postech.domain.repository.ReservaRepository;
import com.hackaton.postech.useCase.contract.IReservaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService {

    private final ReservaRepository repository;
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
        var reservaSaved = repository.save(reservaMapper.convertToReserva(reservaRequestDTO));

        return reservaMapper.convertToReservaResponse(reservaSaved);
    }

    @Override
    public ReservaResponseDTO update(Long id, ReservaRequestDTO reservaRequestDTO) {

        try {
            var reserva = repository.getReferenceById(id);
            var reservaUpdated = reservaMapper.convertToReserva(reservaRequestDTO);
            reservaUpdated.setId(reserva.getId());

            reserva = repository.save(reservaUpdated);
            return reservaMapper.convertToReservaResponse(reserva);
        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException("Reserva não encontrada, id: " + id);
        }

    }

    @Override
    public void deleteById(Long id) {
        try {
            repository.findById(id);
            repository.deleteById(id);
        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException("Reserva não encontrada, id: " + id);
        }
    }

    private Reserva findByIdReserva(Long reservaId) {
        return repository.findById(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrado na base de dados."));
    }
}
