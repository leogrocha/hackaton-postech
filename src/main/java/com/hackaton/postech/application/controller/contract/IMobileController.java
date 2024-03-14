package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.MobileRequestDTO;
import com.hackaton.postech.domain.dto.response.MobileResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IMobileController {

    @GetMapping
    List<MobileResponseDTO> getAll();

    @GetMapping("{mobileId}")
    MobileResponseDTO getById(@PathVariable Long mobileId);

    @PostMapping
    MobileResponseDTO create(@RequestBody @Valid MobileRequestDTO mobileRequestDTO);

    @PutMapping("{mobileId}")
    MobileResponseDTO update(@PathVariable Long mobileId, @RequestBody @Valid MobileRequestDTO mobileRequestDTO);

    @DeleteMapping("{mobileId}")
    void deleteById(@PathVariable Long mobileId);
    
}
