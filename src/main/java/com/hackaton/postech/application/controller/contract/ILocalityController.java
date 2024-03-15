package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalityResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface ILocalityController {

    @GetMapping
    Page<LocalityResponseDTO> findAll(Integer page, Integer linesPorPage);

    @GetMapping("{localityId}")
    LocalityResponseDTO findById(@PathVariable Long localityId);

    @PostMapping
    LocalityResponseDTO save(@RequestBody @Valid LocalityRequestDTO localityRequestDTO);

    @PutMapping("{localityId}")
    LocalityResponseDTO update(@PathVariable Long localityId, @RequestBody @Valid LocalityRequestDTO localityRequestDTO);

    @DeleteMapping("{localityId}")
    void deleteById(@PathVariable Long localityId);
    
}
