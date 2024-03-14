package com.hackaton.postech.useCase.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hackaton.postech.application.mapper.LocalidadeMapper;
import com.hackaton.postech.application.mapper.PredioMapper;
import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.domain.model.Predio;
import com.hackaton.postech.domain.repository.PredioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

public class PredioServiceTest {

    @Mock
    private PredioRepository repository;

    @Mock
    private PredioMapper predioMapper;

    @Mock
    private LocalidadeService localidadeService;

    @Mock
    private LocalidadeMapper localidadeMapper;

    @InjectMocks
    private PredioService predioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(repository.findAll()).thenReturn(List.of(new Predio(), new Predio()));
        when(predioMapper.convertToPredioResponseDTO(any())).thenReturn(new PredioResponseDTO());

        // Act
        List<PredioResponseDTO> responseDTOList = predioService.getAll();

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
    }

    @Test
    public void testGetById() {
        // Arrange
        Predio predio = new Predio();
        predio.setId(1L);
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(predio));
        when(predioMapper.convertToPredioResponseDTO(predio)).thenReturn(new PredioResponseDTO());

        // Act
        PredioResponseDTO responseDTO = predioService.getById(1L);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testGetByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> predioService.getById(1L));
    }

    @Test
    public void testCreate() {
        // Arrange
        PredioRequestDTO requestDTO = new PredioRequestDTO();
        requestDTO.setNome("Test Predio");

        Predio predio = new Predio();
        predio.setId(1L);

        when(repository.save(any())).thenReturn(predio);
        when(predioMapper.convertToPredioResponseDTO(predio)).thenReturn(new PredioResponseDTO());

        // Act
        PredioResponseDTO responseDTO = predioService.create(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testUpdate() {
        // Arrange
        PredioRequestDTO requestDTO = new PredioRequestDTO();
        requestDTO.setNome("Updated Predio");

        Predio predio = new Predio();
        predio.setId(1L);

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(predio));
        when(repository.save(any())).thenReturn(predio);
        when(predioMapper.convertToPredioResponseDTO(predio)).thenReturn(new PredioResponseDTO());

        // Act
        PredioResponseDTO responseDTO = predioService.update(1L, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
        assertEquals("Updated Predio", responseDTO.getNome());
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        PredioRequestDTO requestDTO = new PredioRequestDTO();
        requestDTO.setNome("Updated Predio");

        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> predioService.update(1L, requestDTO));
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Predio predio = new Predio();
        predio.setId(1L);
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(predio));

        // Act
        predioService.deleteById(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> predioService.deleteById(1L));
    }

}
