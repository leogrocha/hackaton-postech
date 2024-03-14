package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.AmenitiesRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenitiesResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IAmenitiesController {

    @GetMapping
    List<AmenitiesResponseDTO> getAll();

    @GetMapping("{amenitiesId}")
    AmenitiesResponseDTO getById(@PathVariable Long amenitiesId);

    @PostMapping
    AmenitiesResponseDTO create(@RequestBody @Valid AmenitiesRequestDTO amenitiesRequestDTO);

    @PutMapping("{amenitiesId}")
    AmenitiesResponseDTO update(@PathVariable Long amenitiesId, @RequestBody @Valid AmenitiesRequestDTO amenitiesRequestDTO);

    @DeleteMapping("{amenitiesId}")
    void deleteById(@PathVariable Long amenitiesId);
    
}
