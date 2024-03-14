package com.hackaton.postech.application.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class EnderecoMapperTest {

    private EnderecoMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(EnderecoMapper.class);
    }

    @Test
    public void testConvertToEnderecoResponseDTO() {
        // Arrange
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setRua("Test Street");
        endereco.setNumero(123);
        endereco.setBairro("Test Neighborhood");
        endereco.setCidade("Test City");
        endereco.setEstado("Test State");

        // Act
        EnderecoResponseDTO responseDTO = mapper.convertToEnderecoResponseDTO(endereco);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(endereco.getId(), responseDTO.getId());
        assertEquals(endereco.getRua(), responseDTO.getRua());
        assertEquals(endereco.getNumero(), responseDTO.getNumero());
        assertEquals(endereco.getBairro(), responseDTO.getBairro());
        assertEquals(endereco.getCidade(), responseDTO.getCidade());
        assertEquals(endereco.getEstado(), responseDTO.getEstado());
    }

    @Test
    public void testConvertToEndereco() {
        // Arrange
        EnderecoRequestDTO requestDTO = new EnderecoRequestDTO();
        requestDTO.setRua("Test Street");
        requestDTO.setNumero(123);
        requestDTO.setBairro("Test Neighborhood");
        requestDTO.setCidade("Test City");
        requestDTO.setEstado("Test State");

        // Act
        Endereco endereco = mapper.convertToEndereco(requestDTO);

        // Assert
        assertNotNull(endereco);
        assertEquals(requestDTO.getRua(), endereco.getRua());
        assertEquals(requestDTO.getNumero(), endereco.getNumero());
        assertEquals(requestDTO.getBairro(), endereco.getBairro());
        assertEquals(requestDTO.getCidade(), endereco.getCidade());
        assertEquals(requestDTO.getEstado(), endereco.getEstado());
    }

    @Test
    public void testConvertToEnderecoFromResponseDTO() {
        // Arrange
        EnderecoResponseDTO responseDTO = new EnderecoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setRua("Test Street");
        responseDTO.setNumero(123);
        responseDTO.setBairro("Test Neighborhood");
        responseDTO.setCidade("Test City");
        responseDTO.setEstado("Test State");

        // Act
        Endereco endereco = mapper.convertToEndereco(responseDTO);

        // Assert
        assertNotNull(endereco);
        assertEquals(responseDTO.getId(), endereco.getId());
        assertEquals(responseDTO.getRua(), endereco.getRua());
        assertEquals(responseDTO.getNumero(), endereco.getNumero());
        assertEquals(responseDTO.getBairro(), endereco.getBairro());
        assertEquals(responseDTO.getCidade(), endereco.getCidade());
        assertEquals(responseDTO.getEstado(), endereco.getEstado());
    }

    @Test
    public void testConvertToEnderecoWithId() {
        // Arrange
        EnderecoRequestDTO requestDTO = new EnderecoRequestDTO();
        requestDTO.setRua("Test Street");
        requestDTO.setNumero(123);
        requestDTO.setBairro("Test Neighborhood");
        requestDTO.setCidade("Test City");
        requestDTO.setEstado("Test State");
        Long id = 1L;

        // Act
        Endereco endereco = mapper.convertToEnderecoWithId(requestDTO, id);

        // Assert
        assertNotNull(endereco);
        assertEquals(id, endereco.getId());
        assertEquals(requestDTO.getRua(), endereco.getRua());
        assertEquals(requestDTO.getNumero(), endereco.getNumero());
        assertEquals(requestDTO.getBairro(), endereco.getBairro());
        assertEquals(requestDTO.getCidade(), endereco.getCidade());
        assertEquals(requestDTO.getEstado(), endereco.getEstado());
    }
}
