package com.hackaton.postech.application.controller.contract;

import com.hackaton.postech.domain.dto.request.RoomRequestDTO;
import com.hackaton.postech.domain.dto.response.RoomResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IRoomController {

    @GetMapping
    List<RoomResponseDTO> getAll();

    @GetMapping("{mobileId}")
    RoomResponseDTO getById(@PathVariable Long mobileId);

    @PostMapping
    RoomResponseDTO create(@RequestBody @Valid RoomRequestDTO roomRequestDTO);

    @PutMapping("{mobileId}")
    RoomResponseDTO update(@PathVariable Long mobileId, @RequestBody @Valid RoomRequestDTO quartoRequest);

    @DeleteMapping("{mobileId}")
    void deleteById(@PathVariable Long mobileId);
    
}
