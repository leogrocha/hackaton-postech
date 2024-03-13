package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IPredioController;
import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.useCase.contract.IPredioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/predios")
public class PredioController implements IPredioController {

    private final IPredioService service;

    @Override
    public List<PredioResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public PredioResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public PredioResponseDTO create(PredioRequestDTO predioRequest) {
        return service.create(predioRequest);
    }

    @Override
    public PredioResponseDTO update(Long id, PredioRequestDTO predioRequest) {
        return service.update(id, predioRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
    
}
