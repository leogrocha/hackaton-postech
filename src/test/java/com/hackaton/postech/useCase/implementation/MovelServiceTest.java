package com.hackaton.postech.useCase.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hackaton.postech.application.mapper.MovelMapper;
import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.domain.model.Movel;
import com.hackaton.postech.domain.repository.MovelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class MovelServiceTest {

    @Mock
    private MovelRepository repository;

    @Mock
    private MovelMapper movelMapper;

    @InjectMocks
    private MovelService movelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(repository.findAll()).thenReturn(List.of(new Movel(), new Movel()));
        when(movelMapper.convertToMovelResponseDTO(any())).thenReturn(new MovelResponseDTO());

        // Act
        List<MovelResponseDTO> responseDTOList = movelService.getAll();

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
    }

    @Test
    public void testGetById() {
        // Arrange
        Movel movel = new Movel();
        movel.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(movel));
        when(movelMapper.convertToMovelResponseDTO(movel)).thenReturn(new MovelResponseDTO());

        // Act
        MovelResponseDTO responseDTO = movelService.getById(1L);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testGetByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> movelService.getById(1L));
    }

    @Test
    public void testCreate() {
        // Arrange
        MovelRequestDTO requestDTO = new MovelRequestDTO();
        requestDTO.setDescricao("Test Movel");

        Movel movel = new Movel();
        movel.setId(1L);

        when(repository.save(any())).thenReturn(movel);
        when(movelMapper.convertToMovelResponseDTO(movel)).thenReturn(new MovelResponseDTO());

        // Act
        MovelResponseDTO responseDTO = movelService.create(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testUpdate() {
        // Arrange
        MovelRequestDTO requestDTO = new MovelRequestDTO();
        requestDTO.setDescricao("Updated Movel");

        Movel movel = new Movel();
        movel.setId(1L);

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(movel));
        when(repository.save(any())).thenReturn(movel);
        when(movelMapper.convertToMovelResponseDTO(movel)).thenReturn(new MovelResponseDTO());

        // Act
        MovelResponseDTO responseDTO = movelService.update(1L, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
        assertEquals("Updated Movel", responseDTO.getDescricao());
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        MovelRequestDTO requestDTO = new MovelRequestDTO();
        requestDTO.setDescricao("Updated Movel");

        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> movelService.update(1L, requestDTO));
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Movel movel = new Movel();
        movel.setId(1L);
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(movel));

        // Act
        movelService.deleteById(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> movelService.deleteById(1L));
    }

}
