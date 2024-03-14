package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IEnderecoController;
import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.useCase.contract.IEnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/enderecos")
public class EnderecoController implements IEnderecoController {

    private final IEnderecoService service;

    @Override
    public List<EnderecoResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public EnderecoResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public EnderecoResponseDTO create(EnderecoRequestDTO enderecoRequest) {
        return service.create(enderecoRequest);
    }

    @Override
    public EnderecoResponseDTO update(Long id, EnderecoRequestDTO enderecoRequest) {
        return service.update(id, enderecoRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

}
