package com.hackaton.postech.application.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.domain.model.Amenidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class AmenidadeMapperTest {

    private AmenidadeMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(AmenidadeMapper.class);
    }

    @Test
    public void testConvertToAmenidadeResponseDTO() {
        // Arrange
        Amenidade amenidade = new Amenidade();
        amenidade.setId(1L);
        amenidade.setDescricao("Test Description");
        amenidade.setIdLocalidade(100L);

        // Act
        AmenidadeResponseDTO responseDTO = mapper.convertToAmenidadeResponseDTO(amenidade);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(amenidade.getId(), responseDTO.getId());
        assertEquals(amenidade.getDescricao(), responseDTO.getDescricao());
        assertEquals(amenidade.getIdLocalidade(), responseDTO.getIdLocalidade());
    }

    @Test
    public void testConvertToAmenidade() {
        // Arrange
        AmenidadeRequestDTO requestDTO = new AmenidadeRequestDTO();
        requestDTO.setDescricao("Test Description");
        requestDTO.setIdLocalidade(100L);

        // Act
        Amenidade amenidade = mapper.convertToAmenidade(requestDTO);

        // Assert
        assertNotNull(amenidade);
        assertEquals(requestDTO.getDescricao(), amenidade.getDescricao());
        assertEquals(requestDTO.getIdLocalidade(), amenidade.getIdLocalidade());
    }

    @Test
    public void testConvertToAmenidadeWithId() {
        // Arrange
        AmenidadeRequestDTO requestDTO = new AmenidadeRequestDTO();
        requestDTO.setDescricao("Test Description");
        requestDTO.setIdLocalidade(100L);
        Long id = 1L;

        // Act
        Amenidade amenidade = mapper.convertToAmenidadeWithId(requestDTO, id);

        // Assert
        assertNotNull(amenidade);
        assertEquals(id, amenidade.getId());
        assertEquals(requestDTO.getDescricao(), amenidade.getDescricao());
        assertEquals(requestDTO.getIdLocalidade(), amenidade.getIdLocalidade());
    }
}



