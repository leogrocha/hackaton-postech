package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.BuildingRequestDTO;
import com.hackaton.postech.domain.dto.request.BuildingUpdateDTO;
import com.hackaton.postech.domain.dto.response.BuildingResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

public interface IBuildingController {

    @GetMapping
    Page<BuildingResponseDTO> getAll(Integer page, Integer linesPorPage);

    @GetMapping("{buildingId}")
    BuildingResponseDTO getById(@PathVariable Long buildingId);

    @PostMapping
    BuildingResponseDTO create(@RequestBody @Valid BuildingRequestDTO buildingRequestDTO);

    @PutMapping("{buildingId}")
    BuildingUpdateDTO update(@PathVariable Long buildingId, @RequestBody @Valid BuildingUpdateDTO buildingUpdateDTO);

    @DeleteMapping("{buildingId}")
    void deleteById(@PathVariable Long buildingId);
    
}
