package com.hackaton.postech.application.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.domain.model.Movel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class MovelMapperTest {

    private MovelMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(MovelMapper.class);
    }

    @Test
    public void testConvertToMovelResponseDTO() {
        // Arrange
        Movel movel = new Movel();
        movel.setId(1L);
        movel.setDescricao("Test Description");

        // Act
        MovelResponseDTO responseDTO = mapper.convertToMovelResponseDTO(movel);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(movel.getId(), responseDTO.getId());
        assertEquals(movel.getDescricao(), responseDTO.getDescricao());
    }

    @Test
    public void testConvertToMovel() {
        // Arrange
        MovelRequestDTO requestDTO = new MovelRequestDTO();
        requestDTO.setDescricao("Test Description");

        // Act
        Movel movel = mapper.convertToMovel(requestDTO);

        // Assert
        assertNotNull(movel);
        assertEquals(requestDTO.getDescricao(), movel.getDescricao());
    }

    @Test
    public void testConvertToMovelWithId() {
        // Arrange
        MovelRequestDTO requestDTO = new MovelRequestDTO();
        requestDTO.setDescricao("Test Description");
        Long id = 1L;

        // Act
        Movel movel = mapper.convertToMovelWithId(requestDTO, id);

        // Assert
        assertNotNull(movel);
        assertEquals(id, movel.getId());
        assertEquals(requestDTO.getDescricao(), movel.getDescricao());
    }
}
