package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.exceptions.NotFoundException;
import com.hackaton.postech.application.mapper.ClientMapper;
import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import com.hackaton.postech.domain.model.Client;
import com.hackaton.postech.domain.repository.ClientRepository;
import com.hackaton.postech.useCase.contract.IClientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

  private final ClientRepository repository;
  private final ClientMapper mapper;

  public List<ClientResponseDTO> findAll() {
    return repository.findAll()
        .stream()
        .map(mapper::convertToClientResponse)
        .toList();
  }

  public ClientResponseDTO findById(Long clientId) {
    return  mapper.convertToClientResponse(findByIdClient(clientId));
  }

  public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
    var clientSaved = repository.save(mapper.convertToClient(clientRequestDTO));

    return mapper.convertToClientResponse(clientSaved);
  }

  public ClientResponseDTO update(Long clientId, ClientRequestDTO clientRequestDTO) {

    try {
      var client = repository.getReferenceById(clientId);
      var clientUpdated = mapper.convertToClient(clientRequestDTO);
      clientUpdated.setClientId(client.getClientId());

      client = repository.save(clientUpdated);
      return mapper.convertToClientResponse(client);
    } catch (EntityNotFoundException exception) {
      throw new NotFoundException("Cliente não encontrado, id: " + clientId);
    }
  }

  public void deleteById(Long clientId) {

    try {
      repository.findById(clientId);
      repository.deleteById(clientId);
    } catch (EntityNotFoundException exception) {
      throw new NotFoundException("Cliente não encontrado, id: " + clientId);
    }
  }

  private Client findByIdClient(Long clientId) {
    return repository.findById(clientId)
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado na base de dados."));
  }






}
