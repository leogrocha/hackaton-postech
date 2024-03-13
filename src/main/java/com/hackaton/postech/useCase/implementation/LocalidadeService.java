package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.EnderecoMapper;
import com.hackaton.postech.application.mapper.LocalidadeMapper;
import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
import com.hackaton.postech.domain.repository.EnderecoRepository;
import com.hackaton.postech.domain.repository.LocalidadeRepository;
import com.hackaton.postech.useCase.contract.IEnderecoService;
import com.hackaton.postech.useCase.contract.ILocalidadeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalidadeService implements ILocalidadeService {

    private static final String LOCALIDADE_NOT_FOUND = "Not found localidade ID: ";
    private final LocalidadeRepository repository;
    private final LocalidadeMapper localidadeMapper;


    @Override
    public List<LocalidadeResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(localidadeMapper::convertToLocalidadeResponseDTO)
                .toList();
    }

    @Override
    public LocalidadeResponseDTO getById(Long id) {
        return localidadeMapper.convertToLocalidadeResponseDTO(findById(id));
    }

    @Override
    public LocalidadeResponseDTO create(LocalidadeRequestDTO localidadeRequest) {
        return localidadeMapper.convertToLocalidadeResponseDTO(repository
                .save(localidadeMapper.convertToLocalidade(localidadeRequest)));
    }

    @Override
    public LocalidadeResponseDTO update(Long id, LocalidadeRequestDTO localidadeRequest) {
        getById(id);
        return localidadeMapper.convertToLocalidadeResponseDTO(repository
                .save(localidadeMapper.convertToLocalidadeWithId(localidadeRequest, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Localidade findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(LOCALIDADE_NOT_FOUND + id));
    }
}
