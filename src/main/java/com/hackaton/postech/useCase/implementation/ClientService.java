package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.exceptions.NotFoundException;
import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import com.hackaton.postech.domain.model.Address;
import com.hackaton.postech.domain.model.Client;
import com.hackaton.postech.domain.repository.AddressRepository;
import com.hackaton.postech.domain.repository.ClientRepository;
import com.hackaton.postech.useCase.contract.IClientService;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

  private final ClientRepository repository;
  private final AddressRepository addressRepository;

  @Transactional(readOnly = true)
  public Page<ClientResponseDTO> findAll(PageRequest pageRequest) {
    var clients = repository.findAll(pageRequest);
    return clients.map(ClientResponseDTO::of);

  }
  @Transactional(readOnly = true)
  public ClientResponseDTO findById(Long clientId) {

    return repository.findById(clientId)
        .stream()
        .map(ClientResponseDTO::of)
        .findFirst()
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
  }

  @Transactional
  public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {

    var addressSaved = addressRepository.save(Address.ofSave(clientRequestDTO.getAddress()));
    var clientSaved = repository.save(Client.ofSave(clientRequestDTO, AddressRequestDTO.of(addressSaved)));

    return ClientResponseDTO.of(clientSaved);
  }

  @Transactional
  public ClientResponseDTO update(Long clientId, ClientRequestDTO clientRequestDTO) {

    try {

      var clientUpdate = repository.getReferenceById(clientId);
      var addressUpdate = Address.ofUpdate(clientRequestDTO.getAddress());
      addressUpdate.setAddressId(clientUpdate.getClientId());
      clientRequestDTO.setClientId(clientUpdate.getClientId());
      ClientRequestDTO.mapperEntity(clientRequestDTO, clientUpdate, addressUpdate);

      addressUpdate = addressRepository.save(addressUpdate);
      clientUpdate = repository.save(clientUpdate);
      return ClientResponseDTO.of(clientUpdate);
    } catch (EntityNotFoundException exception) {
      throw new NotFoundException("Cliente não encontrado, id: " + clientId);
    }
  }

  @Transactional
  public void deleteById(Long clientId) {

    if(repository.existsById(clientId)) {
      repository.deleteById(clientId);
    } else {
      throw new NotFoundException("Recurso não encontrado");
    }
  }








}
