package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.mapper.EnderecoMapper;
import com.hackaton.postech.application.mapper.LocalidadeMapper;
import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
import com.hackaton.postech.domain.repository.LocalidadeRepository;
import com.hackaton.postech.useCase.contract.ILocalidadeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalidadeService implements ILocalidadeService {

    private static final String LOCALIDADE_NOT_FOUND = "Not found localidade ID: ";

    private final LocalidadeRepository repository;
    private final LocalidadeMapper localidadeMapper;
    private final EnderecoService enderecoService;
    private final EnderecoMapper enderecoMapper;

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

        try {
            Localidade localidade = new Localidade(localidadeRequest);
            Endereco endereco = enderecoMapper.convertToEndereco(enderecoService.getById(localidadeRequest.getIdEndereco()));

            localidade.setEndereco(endereco);

            repository.save(localidade);
            return localidadeMapper.convertToLocalidadeResponseDTO(localidade);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Localidade already exists at this address", e);
        }
    }

    @Override
    public LocalidadeResponseDTO update(Long id, LocalidadeRequestDTO localidadeRequest) {

        LocalidadeResponseDTO localidadeResponse = getById(id);
        localidadeResponse.setNome(localidadeRequest.getNome());
        localidadeResponse.setEndereco(enderecoService.getById(localidadeRequest.getIdEndereco()));

        repository.save(localidadeMapper.convertToLocalidade(localidadeResponse));

        return localidadeResponse;
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
