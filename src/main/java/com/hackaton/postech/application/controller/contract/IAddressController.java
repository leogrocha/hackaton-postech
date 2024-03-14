package com.hackaton.postech.application.controller.contract;


import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import com.hackaton.postech.domain.dto.response.AddressResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface IAddressController {
    @GetMapping
    List<AddressResponseDTO> getAll();

    @GetMapping("{addressId}")
    AddressResponseDTO getById(@PathVariable Long addressId);

    @PostMapping
    AddressResponseDTO create(@RequestBody @Valid AddressRequestDTO addressRequestDTO);

    @PutMapping("{addressId}")
    AddressResponseDTO update(@PathVariable Long addressId, @RequestBody @Valid AddressRequestDTO addressRequestDTO);

    @DeleteMapping("{addressId}")
    void deleteById(@PathVariable Long addressId);
}
