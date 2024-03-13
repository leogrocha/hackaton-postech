package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IAmenidadeController {

    @GetMapping
    public List<AmenidadeResponseDTO> getAll();

    @GetMapping("{id}")
    public AmenidadeResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public AmenidadeResponseDTO create(@RequestBody @Valid AmenidadeRequestDTO amenidadeRequest);

    @PutMapping("{id}")
    public AmenidadeResponseDTO update(@PathVariable Long id, @RequestBody @Valid AmenidadeRequestDTO amenidadeRequest);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
    
}
