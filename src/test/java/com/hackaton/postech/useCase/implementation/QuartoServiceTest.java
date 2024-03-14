package com.hackaton.postech.useCase.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hackaton.postech.application.mapper.QuartoMapper;
import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.model.Quarto;
import com.hackaton.postech.domain.repository.QuartoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class QuartoServiceTest {

    @Mock
    private QuartoRepository repository;

    @Mock
    private QuartoMapper quartoMapper;

    @InjectMocks
    private QuartoService quartoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(repository.findAll()).thenReturn(List.of(new Quarto(), new Quarto()));
        when(quartoMapper.convertToQuartoResponseDTO(any())).thenReturn(new QuartoResponseDTO());

        // Act
        List<QuartoResponseDTO> responseDTOList = quartoService.getAll();

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
    }

    @Test
    public void testGetById() {
        // Arrange
        Quarto quarto = new Quarto();
        quarto.setId(1L);
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(quarto));
        when(quartoMapper.convertToQuartoResponseDTO(quarto)).thenReturn(new QuartoResponseDTO());

        // Act
        QuartoResponseDTO responseDTO = quartoService.getById(1L);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testGetByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> quartoService.getById(1L));
    }

    @Test
    public void testCreate() {
        // Arrange
        QuartoRequestDTO requestDTO = new QuartoRequestDTO();

        Quarto quarto = new Quarto();
        quarto.setId(1L);

        when(repository.save(any())).thenReturn(quarto);
        when(quartoMapper.convertToQuartoResponseDTO(quarto)).thenReturn(new QuartoResponseDTO());

        // Act
        QuartoResponseDTO responseDTO = quartoService.create(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testUpdate() {
        // Arrange
        QuartoRequestDTO requestDTO = new QuartoRequestDTO();

        Quarto quarto = new Quarto();
        quarto.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(quarto));
        when(repository.save(any())).thenReturn(quarto);
        when(quartoMapper.convertToQuartoResponseDTO(quarto)).thenReturn(new QuartoResponseDTO());

        // Act
        QuartoResponseDTO responseDTO = quartoService.update(1L, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        QuartoRequestDTO requestDTO = new QuartoRequestDTO();

        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> quartoService.update(1L, requestDTO));
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Quarto quarto = new Quarto();
        quarto.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(quarto));

        // Act
        quartoService.deleteById(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> quartoService.deleteById(1L));
    }

}
