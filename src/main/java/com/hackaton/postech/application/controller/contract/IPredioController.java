package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPredioController {

    @GetMapping
    public List<PredioResponseDTO> getAll();

    @GetMapping("{id}")
    public PredioResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public PredioResponseDTO create(@RequestBody @Valid PredioRequestDTO PredioRequest);

    @PutMapping("{id}")
    public PredioResponseDTO update(@PathVariable Long id, @RequestBody @Valid PredioRequestDTO PredioRequest);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
    
}
