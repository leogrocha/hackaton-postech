package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalityResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface ILocalityController {

    @GetMapping
    List<LocalityResponseDTO> getAll();

    @GetMapping("{localityId}")
    LocalityResponseDTO getById(@PathVariable Long localityId);

    @PostMapping
    LocalityResponseDTO create(@RequestBody @Valid LocalityRequestDTO localityRequestDTO);

    @PutMapping("{localityId}")
    LocalityResponseDTO update(@PathVariable Long localityId, @RequestBody @Valid LocalityRequestDTO localityRequestDTO);

    @DeleteMapping("{localityId}")
    void deleteById(@PathVariable Long localityId);
    
}
