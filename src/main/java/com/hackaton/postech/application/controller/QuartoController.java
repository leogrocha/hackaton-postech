package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IQuartoController;
import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.useCase.contract.IQuartoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/quartos")
public class QuartoController implements IQuartoController {

    private final IQuartoService service;

    @Override
    public List<QuartoResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public QuartoResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public QuartoResponseDTO create(QuartoRequestDTO quartoRequest) {
        return service.create(quartoRequest);
    }

    @Override
    public QuartoResponseDTO update(Long id, QuartoRequestDTO quartoRequest) {
        return service.update(id, quartoRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }   
    
}
