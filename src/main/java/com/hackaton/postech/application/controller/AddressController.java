package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IAddressController;
import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import com.hackaton.postech.domain.dto.response.AddressResponseDTO;
import com.hackaton.postech.useCase.contract.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("address")
public class AddressController implements IAddressController {

    private final IAddressService service;

    @Override
    public List<AddressResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public AddressResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public AddressResponseDTO create(AddressRequestDTO enderecoRequest) {
        return service.create(enderecoRequest);
    }

    @Override
    public AddressResponseDTO update(Long id, AddressRequestDTO enderecoRequest) {
        return service.update(id, enderecoRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

}
