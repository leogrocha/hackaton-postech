package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.request.ReservaRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.dto.response.ReservaResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IReservaController {

    @GetMapping
    public List<ReservaResponseDTO> getAll();

    @GetMapping("{id}")
    public ReservaResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public ReservaResponseDTO create(@RequestBody @Valid ReservaRequestDTO reservaRequestDTO);

    @PutMapping("{id}")
    public ReservaResponseDTO update(@PathVariable Long id, @RequestBody @Valid ReservaRequestDTO reservaRequestDTO);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
    
}
