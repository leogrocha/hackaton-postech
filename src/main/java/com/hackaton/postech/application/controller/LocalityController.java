package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.ILocalityController;

import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalityResponseDTO;
import com.hackaton.postech.useCase.contract.ILocalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/localidades")
public class LocalityController implements ILocalityController {

    private final ILocalityService service;

    @Override
    public List<LocalityResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public LocalityResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public LocalityResponseDTO create(LocalityRequestDTO localidadeRequest) {
        return service.create(localidadeRequest);
    }

    @Override
    public LocalityResponseDTO update(Long id, LocalityRequestDTO localidadeRequest) {
        return service.update(id, localidadeRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
    
}
