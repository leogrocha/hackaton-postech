package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IMobileController;
import com.hackaton.postech.domain.dto.request.MobileRequestDTO;
import com.hackaton.postech.domain.dto.response.MobileResponseDTO;
import com.hackaton.postech.useCase.contract.IMobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/moveis")
public class MobileController implements IMobileController {

    private final IMobileService service;

    @Override
    public List<MobileResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public MobileResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public MobileResponseDTO create(MobileRequestDTO movelRequest) {
        return service.create(movelRequest);
    }

    @Override
    public MobileResponseDTO update(Long id, MobileRequestDTO movelRequest) {
        return service.update(id, movelRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
    
}
