package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IBuildingController;
import com.hackaton.postech.domain.dto.request.BuildingRequestDTO;
import com.hackaton.postech.domain.dto.request.BuildingUpdateDTO;
import com.hackaton.postech.domain.dto.response.BuildingResponseDTO;
import com.hackaton.postech.useCase.contract.IBuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("building")
public class BuildingController implements IBuildingController {

    private final IBuildingService service;

    @Override
    public Page<BuildingResponseDTO> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPorPage) {

        PageRequest pageRequest = PageRequest.of(page, linesPorPage);
        return service.findAll(pageRequest);
    }

    @Override
    public BuildingResponseDTO getById(Long id) {
        return service.findById(id);
    }

    @Override
    public BuildingResponseDTO create(BuildingRequestDTO predioRequest) {
        return service.save(predioRequest);
    }

    @Override
    public BuildingUpdateDTO update(Long id, BuildingUpdateDTO buildingUpdateDTO) {
        return service.update(id, buildingUpdateDTO);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
    
}
