package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.BuildingRequestDTO;
import com.hackaton.postech.domain.dto.request.BuildingUpdateDTO;
import com.hackaton.postech.domain.dto.response.BuildingResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IBuildingService {

    Page<BuildingResponseDTO> findAll(PageRequest pageRequest);

    BuildingResponseDTO findById(Long buildingId);

    BuildingResponseDTO save(BuildingRequestDTO buildingRequestDTO);

    BuildingUpdateDTO update(Long buildingId, BuildingUpdateDTO buildingUpdateDTO);

    void deleteById(Long buildingId);
}
