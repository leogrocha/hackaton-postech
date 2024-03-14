package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IClientController;
import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import com.hackaton.postech.useCase.contract.IClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController implements IClientController {

  private final IClientService service;

  @Override
  public ResponseEntity<Page<ClientResponseDTO>>
  findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
          @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPorPage) {
    PageRequest pageRequest = PageRequest.of(page, linesPorPage);
    var clients = service.findAll(pageRequest);
    return ResponseEntity.ok().body(clients);
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<ClientResponseDTO> findById(@PathVariable  Long clientId) {
    return ResponseEntity.ok(service.findById(clientId));
  }

  @PostMapping
  public ResponseEntity<ClientResponseDTO> save(@Valid @RequestBody ClientRequestDTO clientRequestDTO) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{clientId}").buildAndExpand(("/{id}")).toUri();
    return ResponseEntity.created(uri).body(service.save(clientRequestDTO));
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<ClientResponseDTO> update(@RequestBody @Valid ClientRequestDTO clientRequestDTO, @PathVariable Long clientId) {
    return ResponseEntity.ok(service.update(clientId, clientRequestDTO));
  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<Void> update(@PathVariable Long clientId) {
    service.deleteById(clientId);
    return ResponseEntity.noContent().build();
  }






}
