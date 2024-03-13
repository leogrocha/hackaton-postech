package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IMovelController;
import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.useCase.contract.IMovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/Moveis")
public class MovelController implements IMovelController {

    private final IMovelService service;

    @Override
    public List<MovelResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public MovelResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public MovelResponseDTO create(MovelRequestDTO movelRequest) {
        return service.create(movelRequest);
    }

    @Override
    public MovelResponseDTO update(Long id, MovelRequestDTO movelRequest) {
        return service.update(id, movelRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
}
