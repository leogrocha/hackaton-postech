package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IAmenitiesController;
import com.hackaton.postech.domain.dto.request.AmenitiesRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenitiesResponseDTO;
import com.hackaton.postech.useCase.contract.IAmenitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/amenidades")
public class AmenitiesController implements IAmenitiesController {

    private final IAmenitiesService service;

    @Override
    public List<AmenitiesResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public AmenitiesResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public AmenitiesResponseDTO create(AmenitiesRequestDTO amenidadeRequest) {
        return service.create(amenidadeRequest);
    }

    @Override
    public AmenitiesResponseDTO update(Long id, AmenitiesRequestDTO amenidadeRequest) {
        return service.update(id, amenidadeRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
    
}
