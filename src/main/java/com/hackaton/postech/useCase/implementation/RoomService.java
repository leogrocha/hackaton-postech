package com.hackaton.postech.useCase.implementation;

import com.hackaton.postech.application.exceptions.NotFoundException;
import com.hackaton.postech.domain.dto.request.RoomRequestDTO;
import com.hackaton.postech.domain.dto.response.RoomResponseDTO;
import com.hackaton.postech.domain.model.Room;
import com.hackaton.postech.domain.repository.RoomRepository;
import com.hackaton.postech.useCase.contract.IRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService implements IRoomService {

    private static final String ROOM_NOT_FOUND = "Not found Quarto ID: ";

    private final RoomRepository repository;

    @Override
    public List<RoomResponseDTO> getAll() {
        return null;
//        return repository.findAll()
//                .stream()
//                .map(quartoMapper::convertToQuartoResponseDTO)
//                .toList();
    }

    @Override
    public RoomResponseDTO getById(Long id) {
        return null;
//        return quartoMapper.convertToQuartoResponseDTO(findById(id));
    }

    @Override
    public RoomResponseDTO create(RoomRequestDTO roomRequestDTO) {
//        Room quarto = new Room(roomRequestDTO);
//        repository.save(quarto);
//        return quartoMapper.convertToQuartoResponseDTO(quarto);
        return null;
    }

    @Override
    public RoomResponseDTO update(Long id, RoomRequestDTO roomRequestDTO) {
    return null;
//        return quartoMapper.convertToQuartoResponseDTO(repository
//                .save(quartoMapper.convertToQuartoWithId(roomRequestDTO, id)));
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    private Room findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(ROOM_NOT_FOUND + id));
    }
}
