package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface IClientController {

  @GetMapping
  ResponseEntity<Page<ClientResponseDTO>> findAll(Integer page, Integer linesPorPage);

  @GetMapping("/{clientId}")
  ResponseEntity<ClientResponseDTO> findById(@PathVariable Long clientId);

  @PostMapping
  ResponseEntity<ClientResponseDTO> save(@Valid @RequestBody ClientRequestDTO clientRequestDTO);

  @PutMapping("/{clientId}")
  ResponseEntity<ClientResponseDTO> update(@RequestBody @Valid ClientRequestDTO clientRequestDTO, @PathVariable Long clientId);

  @DeleteMapping("/{clientId}")
  ResponseEntity<Void> update(@PathVariable Long clientId);

}
