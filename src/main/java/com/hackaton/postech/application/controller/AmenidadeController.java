package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IAmenidadeController;
import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.useCase.contract.IAmenidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/Amenidades")
public class AmenidadeController implements IAmenidadeController {

    private final IAmenidadeService service;

    @Override
    public List<AmenidadeResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public AmenidadeResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public AmenidadeResponseDTO create(AmenidadeRequestDTO amenidadeRequest) {
        return service.create(amenidadeRequest);
    }

    @Override
    public AmenidadeResponseDTO update(Long id, AmenidadeRequestDTO amenidadeRequest) {
        return service.update(id, amenidadeRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
    
}
