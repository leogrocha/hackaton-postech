package com.hackaton.postech.useCase.contract;

import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalityResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ILocalityService {

    Page<LocalityResponseDTO> findAll(PageRequest pageRequest);

    LocalityResponseDTO findById(Long localityId);

    LocalityResponseDTO save(LocalityRequestDTO localityRequestDTO);

    LocalityResponseDTO update(Long localityId, LocalityRequestDTO localityRequestDTO);

    void deleteById(Long id);
}
