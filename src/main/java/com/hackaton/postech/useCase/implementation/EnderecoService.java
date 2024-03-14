package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.EnderecoMapper;
import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.repository.EnderecoRepository;
import com.hackaton.postech.useCase.contract.IEnderecoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService implements IEnderecoService {

    private static final String ENDERECO_NOT_FOUND = "Not found endereço ID: ";

    @Autowired
    private final EnderecoRepository repository;

    @Autowired
    private final EnderecoMapper enderecoMapper;


    @Override
    public List<EnderecoResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(enderecoMapper::convertToEnderecoResponseDTO)
                .toList();
    }

    @Override
    public EnderecoResponseDTO getById(Long id) {
        return enderecoMapper.convertToEnderecoResponseDTO(findById(id));
    }

    @Override
    public EnderecoResponseDTO create(EnderecoRequestDTO enderecoRequest) {
        return enderecoMapper.convertToEnderecoResponseDTO(repository
                .save(enderecoMapper.convertToEndereco(enderecoRequest)));
    }

    @Override
    public EnderecoResponseDTO update(Long id, EnderecoRequestDTO enderecoRequest) {
        getById(id);
        return enderecoMapper.convertToEnderecoResponseDTO(repository
                .save(enderecoMapper.convertToEnderecoWithId(enderecoRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Endereco findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENDERECO_NOT_FOUND + id));
    }
}
