package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface ILocalidadeController {

    @GetMapping
    public List<LocalidadeResponseDTO> getAll();

    @GetMapping("{id}")
    public LocalidadeResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public LocalidadeResponseDTO create(@RequestBody @Valid LocalidadeRequestDTO localidadeRequest);

    @PutMapping("{id}")
    public LocalidadeResponseDTO update(@PathVariable Long id, @RequestBody @Valid LocalidadeRequestDTO localidadeRequest);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
    
}
