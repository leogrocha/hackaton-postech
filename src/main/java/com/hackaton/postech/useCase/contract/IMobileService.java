package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.MobileRequestDTO;
import com.hackaton.postech.domain.dto.response.MobileResponseDTO;

import java.util.List;

public interface IMobileService {

    List<MobileResponseDTO> getAll();

    MobileResponseDTO getById(Long id);

    MobileResponseDTO create(MobileRequestDTO mobileRequestDTO);

    MobileResponseDTO update(Long id, MobileRequestDTO mobileRequestDTO);

    void deleteById(Long id);

}
