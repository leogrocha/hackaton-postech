package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.AmenidadeMapper;
import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.domain.model.Amenidade;
import com.hackaton.postech.domain.repository.AmenidadeRepository;
import com.hackaton.postech.useCase.contract.IAmenidadeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmenidadeService implements IAmenidadeService {

    private static final String AMENIDADE_NOT_FOUND = "Not found Amenidade ID: ";

    @Autowired
    private final AmenidadeRepository repository;

    @Autowired
    private final AmenidadeMapper amenidadeMapper;


    @Override
    public List<AmenidadeResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(amenidadeMapper::convertToAmenidadeResponseDTO)
                .toList();
    }

    @Override
    public AmenidadeResponseDTO getById(Long id) {
        return amenidadeMapper.convertToAmenidadeResponseDTO(findById(id));
    }

    @Override
    public AmenidadeResponseDTO create(AmenidadeRequestDTO amenidadeRequest) {
        return amenidadeMapper.convertToAmenidadeResponseDTO(repository
                .save(amenidadeMapper.convertToAmenidade(amenidadeRequest)));
    }

    @Override
    public AmenidadeResponseDTO update(Long id, AmenidadeRequestDTO amenidadeRequest) {
        getById(id);
        return amenidadeMapper.convertToAmenidadeResponseDTO(repository
                .save(amenidadeMapper.convertToAmenidadeWithId(amenidadeRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Amenidade findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(AMENIDADE_NOT_FOUND + id));
    }
}
