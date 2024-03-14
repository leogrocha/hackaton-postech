package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IQuartoController {

    @GetMapping
    public List<QuartoResponseDTO> getAll();

    @GetMapping("{id}")
    public QuartoResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public QuartoResponseDTO create(@RequestBody @Valid QuartoRequestDTO quartoRequest);

    @PutMapping("{id}")
    public QuartoResponseDTO update(@PathVariable Long id, @RequestBody @Valid QuartoRequestDTO quartoRequest);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
    
}
