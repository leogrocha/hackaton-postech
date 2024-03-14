package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.ILocalidadeController;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.useCase.contract.ILocalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/localidades")
public class LocalidadeController implements ILocalidadeController {

    private final ILocalidadeService service;

    @Override
    public List<LocalidadeResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public LocalidadeResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public LocalidadeResponseDTO create(LocalidadeRequestDTO localidadeRequest) {
        return service.create(localidadeRequest);
    }

    @Override
    public LocalidadeResponseDTO update(Long id, LocalidadeRequestDTO localidadeRequest) {
        return service.update(id, localidadeRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
    
}
