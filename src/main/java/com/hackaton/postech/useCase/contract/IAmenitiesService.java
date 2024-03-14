package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.AmenitiesRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenitiesResponseDTO;

import java.util.List;

public interface IAmenitiesService {

    List<AmenitiesResponseDTO> getAll();

    AmenitiesResponseDTO getById(Long id);

    AmenitiesResponseDTO create(AmenitiesRequestDTO amenitiesRequest);

    AmenitiesResponseDTO update(Long id, AmenitiesRequestDTO amenitiesRequest);

    void deleteById(Long id);
}
