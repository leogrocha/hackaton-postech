package com.hackaton.postech.useCase.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hackaton.postech.application.mapper.AmenidadeMapper;
import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.domain.model.Amenidade;
import com.hackaton.postech.domain.repository.AmenidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import java.util.List;

public class AmenidadeServiceTest {

    @Mock
    private AmenidadeRepository repository;

    @Mock
    private AmenidadeMapper amenidadeMapper;

    @InjectMocks
    private AmenidadeService amenidadeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(repository.findAll()).thenReturn(List.of(new Amenidade(), new Amenidade()));

        // Act
        List<AmenidadeResponseDTO> responseDTOList = amenidadeService.getAll();

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
    }

    @Test
    public void testGetById() {
        // Arrange
        Amenidade amenidade = new Amenidade();
        amenidade.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(amenidade));
        when(amenidadeMapper.convertToAmenidadeResponseDTO(amenidade)).thenReturn(new AmenidadeResponseDTO());

        // Act
        AmenidadeResponseDTO responseDTO = amenidadeService.getById(1L);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testCreate() {
        // Arrange
        AmenidadeRequestDTO requestDTO = new AmenidadeRequestDTO();
        requestDTO.setDescricao("Test Description");
        Amenidade amenidade = new Amenidade();
        amenidade.setId(1L);
        when(amenidadeMapper.convertToAmenidade(requestDTO)).thenReturn(amenidade);
        when(repository.save(amenidade)).thenReturn(amenidade);
        when(amenidadeMapper.convertToAmenidadeResponseDTO(amenidade)).thenReturn(new AmenidadeResponseDTO());

        // Act
        AmenidadeResponseDTO responseDTO = amenidadeService.create(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testUpdate() {
        // Arrange
        AmenidadeRequestDTO requestDTO = new AmenidadeRequestDTO();
        requestDTO.setDescricao("Test Description");
        Amenidade amenidade = new Amenidade();
        amenidade.setId(1L);
        when(amenidadeMapper.convertToAmenidadeWithId(requestDTO, 1L)).thenReturn(amenidade);
        when(repository.findById(1L)).thenReturn(Optional.of(amenidade));
        when(repository.save(amenidade)).thenReturn(amenidade);
        when(amenidadeMapper.convertToAmenidadeResponseDTO(amenidade)).thenReturn(new AmenidadeResponseDTO());

        // Act
        AmenidadeResponseDTO responseDTO = amenidadeService.update(1L, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Amenidade amenidade = new Amenidade();
        amenidade.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(amenidade));

        // Act
        amenidadeService.deleteById(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> amenidadeService.deleteById(1L));
    }
}
