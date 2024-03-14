package com.hackaton.postech.application.controller;

import com.hackaton.postech.application.controller.contract.IRoomController;
import com.hackaton.postech.domain.dto.request.RoomRequestDTO;
import com.hackaton.postech.domain.dto.response.RoomResponseDTO;
import com.hackaton.postech.useCase.contract.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hackaton/quartos")
public class RoomController implements IRoomController {

    private final IRoomService service;

    @Override
    public List<RoomResponseDTO> getAll() {
        return service.getAll();
    }

    @Override
    public RoomResponseDTO getById(Long id) {
        return service.getById(id);
    }

    @Override
    public RoomResponseDTO create(RoomRequestDTO quartoRequest) {
        return service.create(quartoRequest);
    }

    @Override
    public RoomResponseDTO update(Long id, RoomRequestDTO quartoRequest) {
        return service.update(id, quartoRequest);
    }
    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }   
    
}
