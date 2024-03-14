package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.exceptions.NotFoundException;
import com.hackaton.postech.domain.dto.request.BuildingRequestDTO;
import com.hackaton.postech.domain.dto.request.BuildingUpdateDTO;
import com.hackaton.postech.domain.dto.response.BuildingResponseDTO;
import com.hackaton.postech.domain.model.Building;
import com.hackaton.postech.domain.repository.BuildingRepository;
import com.hackaton.postech.domain.repository.LocalityRepository;
import com.hackaton.postech.useCase.contract.IBuildingService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BuildingService implements IBuildingService {

    private final BuildingRepository repository;
    private final LocalityRepository localityRepository;

    @Transactional(readOnly = true)
    public Page<BuildingResponseDTO> findAll(PageRequest pageRequest) {
        var buildings = repository.findAll(pageRequest);
        return buildings.map(BuildingResponseDTO::of);
    }


    @Transactional(readOnly = true)
    public BuildingResponseDTO findById(Long buildingId) {
        return repository.findById(buildingId)
            .stream()
            .map(BuildingResponseDTO::of)
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Prédio não encontrado"));
    }

    @Transactional
    public BuildingResponseDTO save(BuildingRequestDTO buildingRequestDTO) {

        if (localityRepository.existsById(buildingRequestDTO.getLocality().getLocalityId())) {
            var buildingSaved = repository.save(Building.ofSave(buildingRequestDTO));
            return BuildingResponseDTO.of(buildingSaved);
        } else {
            throw new NotFoundException("Localidade não encontrada");
        }
    }

    @Transactional
    public BuildingUpdateDTO update(Long buildingId, BuildingUpdateDTO buildingUpdateDTO) {

        try {
            var buildingUpdate = repository.getReferenceById(buildingId);
            buildingUpdate = repository.save(Building.ofUpdate(buildingUpdateDTO));

            return BuildingUpdateDTO.of(buildingUpdate);
        } catch (EntityNotFoundException exception) {
            throw new NotFoundException("Prédio não encontrado, id: " + buildingId);
        }

    }


    @Transactional
    public void deleteById(Long buildingId) {

        if(repository.existsById(buildingId)) {
            repository.deleteById(buildingId);
        } else {
            throw new NotFoundException("Recurso não encontrado");
        }
    }


}
