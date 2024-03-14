package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IClienteController {

    @GetMapping
    public List<ClienteResponseDTO> getAll();

    @GetMapping("{id}")
    public ClienteResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public ClienteResponseDTO create(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO);

    @PutMapping("{id}")
    public ClienteResponseDTO update(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO clienteRequestDTO);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
    
}
