package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.domain.dto.request.AmenitiesRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenitiesResponseDTO;
import com.hackaton.postech.domain.model.Amenities;
import com.hackaton.postech.domain.repository.AmenitiesRepository;
import com.hackaton.postech.useCase.contract.IAmenitiesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AmenitiesService implements IAmenitiesService {

    private static final String AMENITIES_NOT_FOUND = "Not found Amenidade ID: ";


    private final AmenitiesRepository repository;
    
    @Override
    public List<AmenitiesResponseDTO> getAll() {
        return null;
//        return repository.findAll()
//                .stream()
//                .map(amenidadeMapper::convertToAmenidadeResponseDTO)
//                .toList();
    }

    @Override
    public AmenitiesResponseDTO getById(Long id) {
        return null;
//        return amenidadeMapper.convertToAmenidadeResponseDTO(findById(id));
    }

    @Override
    public AmenitiesResponseDTO create(AmenitiesRequestDTO amenidadeRequest) {
        return null;
//        return amenidadeMapper.convertToAmenidadeResponseDTO(repository
//                .save(amenidadeMapper.convertToAmenidade(amenidadeRequest)));
    }

    @Override
    public AmenitiesResponseDTO update(Long id, AmenitiesRequestDTO amenidadeRequest) {
        return null;
//        AmenitiesResponseDTO existingAmenidade = getById(id);
//        LocalityRequestDTO newLocalidade = amenidadeRequest.getLocality();
//
//        return amenidadeMapper.convertToAmenidadeResponseDTO(repository
//                .save(amenidadeMapper.convertToAmenidadeWithId(amenidadeRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Amenities findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(AMENITIES_NOT_FOUND + id));
    }
}
