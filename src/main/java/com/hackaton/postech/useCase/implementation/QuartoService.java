package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.QuartoMapper;
import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.model.Quarto;
import com.hackaton.postech.domain.repository.QuartoRepository;
import com.hackaton.postech.useCase.contract.IQuartoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuartoService implements IQuartoService {

    private static final String QUARTO_NOT_FOUND = "Not found Quarto ID: ";

    @Autowired
    private final QuartoRepository repository;

    @Autowired
    private final QuartoMapper quartoMapper;


    @Override
    public List<QuartoResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(quartoMapper::convertToQuartoResponseDTO)
                .toList();
    }

    @Override
    public QuartoResponseDTO getById(Long id) {
        return quartoMapper.convertToQuartoResponseDTO(findById(id));
    }

    @Override
    public QuartoResponseDTO create(QuartoRequestDTO quartoRequest) {
        Quarto quarto = new Quarto(quartoRequest);
        repository.save(quarto);
        return quartoMapper.convertToQuartoResponseDTO(quarto);
    }

    @Override
    public QuartoResponseDTO update(Long id, QuartoRequestDTO QuartoRequest) {

        return quartoMapper.convertToQuartoResponseDTO(repository
                .save(quartoMapper.convertToQuartoWithId(QuartoRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Quarto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(QUARTO_NOT_FOUND + id));
    }
}
