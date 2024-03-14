package com.hackaton.postech.useCase.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hackaton.postech.application.mapper.EnderecoMapper;
import com.hackaton.postech.application.mapper.LocalidadeMapper;
import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
import com.hackaton.postech.domain.repository.LocalidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

public class LocalidadeServiceTest {

    @Mock
    private LocalidadeRepository repository;

    @Mock
    private LocalidadeMapper localidadeMapper;

    @Mock
    private EnderecoService enderecoService;

    @Mock
    private EnderecoMapper enderecoMapper;

    @InjectMocks
    private LocalidadeService localidadeService;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(repository.findAll()).thenReturn(List.of(new Localidade(), new Localidade()));
        when(localidadeMapper.convertToLocalidadeResponseDTO(any())).thenReturn(new LocalidadeResponseDTO());

        // Act
        List<LocalidadeResponseDTO> responseDTOList = localidadeService.getAll();

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
    }

    @Test
    public void testGetById() {
        // Arrange
        Localidade localidade = new Localidade();
        localidade.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(localidade));
        when(localidadeMapper.convertToLocalidadeResponseDTO(localidade)).thenReturn(new LocalidadeResponseDTO());

        // Act
        LocalidadeResponseDTO responseDTO = localidadeService.getById(1L);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testGetByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> localidadeService.getById(1L));
    }

    @Test
    public void testCreate() {
        // Arrange
        LocalidadeRequestDTO requestDTO = new LocalidadeRequestDTO();
        requestDTO.setNome("Test Localidade");
        requestDTO.setIdEndereco(1L);

        Localidade localidade = new Localidade();
        localidade.setId(1L);

        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
        enderecoResponseDTO.setId(1L);

        when(enderecoService.getById(1L)).thenReturn(enderecoResponseDTO);
        when(localidadeMapper.convertToLocalidadeResponseDTO(localidade)).thenReturn(new LocalidadeResponseDTO());
        when(enderecoMapper.convertToEndereco((EnderecoRequestDTO) any())).thenReturn(new Endereco());

        // Act
        LocalidadeResponseDTO responseDTO = localidadeService.create(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testCreateAlreadyExists() {
        // Arrange
        LocalidadeRequestDTO requestDTO = new LocalidadeRequestDTO();
        requestDTO.setNome("Test Localidade");
        requestDTO.setIdEndereco(1L);

        when(enderecoService.getById(1L)).thenReturn(new EnderecoResponseDTO());
        when(repository.save(any())).thenThrow(DataIntegrityViolationException.class);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> localidadeService.create(requestDTO));
    }

    @Test
    public void testUpdate() {
        // Arrange
        LocalidadeRequestDTO requestDTO = new LocalidadeRequestDTO();
        requestDTO.setNome("Updated Localidade");
        requestDTO.setIdEndereco(1L);

        Localidade localidade = new Localidade();
        localidade.setId(1L);

        LocalidadeResponseDTO localidadeResponseDTO = new LocalidadeResponseDTO();
        localidadeResponseDTO.setId(1L);

        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
        enderecoResponseDTO.setId(1L);

        when(localidadeMapper.convertToLocalidadeResponseDTO(localidade)).thenReturn(localidadeResponseDTO);
        when(enderecoService.getById(1L)).thenReturn(enderecoResponseDTO);
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(localidade));

        // Act
        LocalidadeResponseDTO responseDTO = localidadeService.update(1L, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
        assertEquals("Updated Localidade", responseDTO.getNome());
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        LocalidadeRequestDTO requestDTO = new LocalidadeRequestDTO();
        requestDTO.setNome("Updated Localidade");
        requestDTO.setIdEndereco(1L);

        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> localidadeService.update(1L, requestDTO));
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Localidade localidade = new Localidade();
        localidade.setId(1L);
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(localidade));

        // Act
        localidadeService.deleteById(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> localidadeService.deleteById(1L));
    }


}
