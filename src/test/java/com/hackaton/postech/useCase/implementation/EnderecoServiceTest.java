package com.hackaton.postech.useCase.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hackaton.postech.application.mapper.EnderecoMapper;
import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository repository;

    @Mock
    private EnderecoMapper enderecoMapper;

    @InjectMocks
    private EnderecoService enderecoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        when(repository.findAll()).thenReturn(List.of(new Endereco(), new Endereco()));
        when(enderecoMapper.convertToEnderecoResponseDTO(any())).thenReturn(new EnderecoResponseDTO());

        // Act
        List<EnderecoResponseDTO> responseDTOList = enderecoService.getAll();

        // Assert
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());
    }

    @Test
    public void testGetById() {
        // Arrange
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(endereco));
        when(enderecoMapper.convertToEnderecoResponseDTO(endereco)).thenReturn(new EnderecoResponseDTO());

        // Act
        EnderecoResponseDTO responseDTO = enderecoService.getById(1L);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testGetByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> enderecoService.getById(1L));
    }

    @Test
    public void testCreate() {
        // Arrange
        EnderecoRequestDTO requestDTO = new EnderecoRequestDTO();
        requestDTO.setRua("Test Street");
        requestDTO.setNumero(123);
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        when(enderecoMapper.convertToEndereco(requestDTO)).thenReturn(endereco);
        when(repository.save(endereco)).thenReturn(endereco);
        when(enderecoMapper.convertToEnderecoResponseDTO(endereco)).thenReturn(new EnderecoResponseDTO());

        // Act
        EnderecoResponseDTO responseDTO = enderecoService.create(requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testUpdate() {
        // Arrange
        EnderecoRequestDTO requestDTO = new EnderecoRequestDTO();
        requestDTO.setRua("Test Street");
        requestDTO.setNumero(123);
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        when(enderecoMapper.convertToEnderecoWithId(requestDTO, 1L)).thenReturn(endereco);
        when(repository.findById(1L)).thenReturn(Optional.of(endereco));
        when(repository.save(endereco)).thenReturn(endereco);
        when(enderecoMapper.convertToEnderecoResponseDTO(endereco)).thenReturn(new EnderecoResponseDTO());

        // Act
        EnderecoResponseDTO responseDTO = enderecoService.update(1L, requestDTO);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(1L, responseDTO.getId());
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        EnderecoRequestDTO requestDTO = new EnderecoRequestDTO();
        requestDTO.setRua("Test Street");
            requestDTO.setNumero(123);
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> enderecoService.update(1L, requestDTO));
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(endereco));

        // Act
        enderecoService.deleteById(1L);

        // Assert
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> enderecoService.deleteById(1L));
    }
}
