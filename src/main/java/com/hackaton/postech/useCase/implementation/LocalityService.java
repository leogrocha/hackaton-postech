package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.exceptions.NotFoundException;
import com.hackaton.postech.application.mapper.LocalityMapper;
import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import com.hackaton.postech.domain.dto.request.BuildingUpdateDTO;
import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.request.LocalityUpdateDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import com.hackaton.postech.domain.dto.response.LocalityResponseDTO;
import com.hackaton.postech.domain.model.Building;
import com.hackaton.postech.domain.model.Client;
import com.hackaton.postech.domain.model.Locality;
import com.hackaton.postech.domain.repository.LocalityRepository;
import com.hackaton.postech.useCase.contract.ILocalityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalityService implements ILocalityService {


    private final LocalityRepository repository;

    @Transactional(readOnly = true)
    public Page<LocalityResponseDTO> findAll(PageRequest pageRequest) {
        var clients = repository.findAll(pageRequest);
        return clients.map(LocalityResponseDTO::of);
    }

    @Transactional(readOnly = true)
    public LocalityResponseDTO findById(Long localityId) {
        return repository.findById(localityId)
            .stream()
            .map(LocalityResponseDTO::of)
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Localidade não encontrado"));
    }

    @Transactional
    public LocalityResponseDTO save(LocalityRequestDTO localityRequestDTO) {
        var localitySaved = repository.save(Locality.ofSave(localityRequestDTO));
        return LocalityResponseDTO.of(localitySaved);
    }

    @Transactional
    public LocalityResponseDTO update(Long localityId, LocalityUpdateDTO localityUpdateDTO) {

        try {

            var localityUpdate = repository.getReferenceById(localityId);
            localityUpdate = repository.save(Locality.ofUpdate(localityRequestDTO));

            return LocalityResponseDTO.of(localityUpdate);
        } catch (EntityNotFoundException exception) {
            throw new NotFoundException("Localidade não encontrada, id: " + localityId);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }


}
