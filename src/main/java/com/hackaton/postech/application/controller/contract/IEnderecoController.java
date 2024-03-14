package com.hackaton.postech.application.controller.contract;


import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface IEnderecoController {
    @GetMapping
    public List<EnderecoResponseDTO> getAll();

    @GetMapping("{id}")
    public EnderecoResponseDTO getById(@PathVariable Long id);

    @PostMapping
    public EnderecoResponseDTO create(@RequestBody @Valid EnderecoRequestDTO enderecoRequest);

    @PutMapping("{id}")
    public EnderecoResponseDTO update(@PathVariable Long id, @RequestBody @Valid EnderecoRequestDTO enderecoRequest);

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id);
}
