package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IMovelController {

    @GetMapping
    public List<MovelResponseDTO> getAll();

    @GetMapping("{id}")
    public MovelResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public MovelResponseDTO create(@RequestBody @Valid MovelRequestDTO MovelRequest);

    @PutMapping("{id}")
    public MovelResponseDTO update(@PathVariable Long id, @RequestBody @Valid MovelRequestDTO MovelRequest);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
    
}
