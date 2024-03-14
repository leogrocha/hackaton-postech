package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.PredioMapper;
import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.domain.model.Predio;
import com.hackaton.postech.domain.repository.PredioRepository;
import com.hackaton.postech.useCase.contract.IPredioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PredioService implements IPredioService {

    private static final String PREDIO_NOT_FOUND = "Not found Predio ID: ";

    @Autowired
    private final PredioRepository repository;

    @Autowired
    private final PredioMapper predioMapper;


    @Override
    public List<PredioResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(predioMapper::convertToPredioResponseDTO)
                .toList();
    }

    @Override
    public PredioResponseDTO getById(Long id) {
        return predioMapper.convertToPredioResponseDTO(findById(id));
    }

    @Override
    public PredioResponseDTO create(PredioRequestDTO predioRequest) {
        return predioMapper.convertToPredioResponseDTO(repository
                .save(predioMapper.convertToPredio(predioRequest)));
    }

    @Override
    public PredioResponseDTO update(Long id, PredioRequestDTO predioRequest) {
        getById(id);
        return predioMapper.convertToPredioResponseDTO(repository
                .save(predioMapper.convertToPredioWithId(predioRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Predio findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PREDIO_NOT_FOUND + id));
    }
}
