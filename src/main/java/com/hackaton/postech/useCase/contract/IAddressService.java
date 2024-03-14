package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import com.hackaton.postech.domain.dto.response.AddressResponseDTO;

import java.util.List;
public interface IAddressService {

    List<AddressResponseDTO> getAll();

    AddressResponseDTO getById(Long id);

    AddressResponseDTO create(AddressRequestDTO addressRequest);

    AddressResponseDTO update(Long id, AddressRequestDTO addressRequest);

    void deleteById(Long id);

}
