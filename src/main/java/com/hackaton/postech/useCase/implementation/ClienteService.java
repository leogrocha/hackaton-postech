package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.AmenidadeMapper;
import com.hackaton.postech.application.mapper.ClienteMapper;
import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.model.Cliente;
import com.hackaton.postech.domain.repository.AmenidadeRepository;
import com.hackaton.postech.domain.repository.ClienteRepository;
import com.hackaton.postech.useCase.contract.IClienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

  @Autowired
  private final ClienteRepository repository;

  @Autowired
  private final ClienteMapper clienteMapper;

  @Override
  public List<ClienteResponseDTO> getAll() {
    return repository.findAll()
        .stream()
        .map(clienteMapper::convertToClienteResponse)
        .toList();
  }

  @Override
  public ClienteResponseDTO getById(Long id) {

    return clienteMapper.convertToClienteResponse(findByIdCliente(id));
  }

  @Override
  public ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO) {
    var clientSaved = repository.save(clienteMapper.convertToCliente(clienteRequestDTO));

    return clienteMapper.convertToClienteResponse(clientSaved);
  }

  @Override
  public ClienteResponseDTO update(Long id, ClienteRequestDTO clienteRequestDTO) {
    try {
      var cliente = repository.getReferenceById(id);
      var clienteUpdated = clienteMapper.convertToCliente(clienteRequestDTO);
      clienteUpdated.setId(cliente.getId());

      cliente = repository.save(clienteUpdated);
      return clienteMapper.convertToClienteResponse(cliente);
    } catch (EntityNotFoundException exception) {
      throw new EntityNotFoundException("Cliente não encontrado, id: " + id);
    }
  }

  @Override
  public void deleteById(Long id) {
    try {
      repository.findById(id);
      repository.deleteById(id);
    } catch (EntityNotFoundException exception) {
      throw new EntityNotFoundException("Cliente não encontrado, id: " + id);
    }
  }

  private Cliente findByIdCliente(Long clientId) {
    return repository.findById(clientId)
        .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado na base de dados."));
  }
}
