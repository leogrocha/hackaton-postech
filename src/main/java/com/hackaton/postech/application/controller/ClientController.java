package com.hackaton.postech.application.controller;

import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import com.hackaton.postech.useCase.contract.IClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {

  private final IClientService service;

  @GetMapping
  public ResponseEntity<List<ClientResponseDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<ClientResponseDTO> findById(@PathVariable  Long clientId) {
    return ResponseEntity.ok(service.findById(clientId));
  }

  @PostMapping
  public ResponseEntity<ClientResponseDTO> save(@RequestBody ClientRequestDTO clientRequestDTO) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{clientId}").buildAndExpand(("/{id}")).toUri();
    return ResponseEntity.created(uri).body(service.save(clientRequestDTO));
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<ClientResponseDTO> update(@RequestBody ClientRequestDTO clientRequestDTO, @PathVariable Long clientId) {
    return ResponseEntity.ok(service.update(clientId, clientRequestDTO));
  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<Void> update(@PathVariable Long clientId) {
    service.deleteById(clientId);
    return ResponseEntity.noContent().build();
  }






}
