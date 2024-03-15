package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.ILocalityController;

import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalityResponseDTO;
import com.hackaton.postech.useCase.contract.ILocalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/localidades")
public class LocalityController implements ILocalityController {

    private final ILocalityService service;

    @Override
    public Page<LocalityResponseDTO> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                             @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPorPage) {
        PageRequest pageRequest = PageRequest.of(page, linesPorPage);
        return service.findAll(pageRequest);
    }

    @Override
    public LocalityResponseDTO findById(Long id) {
        return service.findById(id);
    }

    @Override
    public LocalityResponseDTO save(LocalityRequestDTO localidadeRequest) {
        return service.save(localidadeRequest);
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
