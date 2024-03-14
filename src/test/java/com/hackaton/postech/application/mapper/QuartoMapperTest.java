package com.hackaton.postech.application.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.enums.TipoQuarto;
import com.hackaton.postech.domain.model.Movel;
import com.hackaton.postech.domain.model.Quarto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class QuartoMapperTest {

    private QuartoMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(QuartoMapper.class);
    }

    @Test
    public void testConvertToQuartoResponseDTO() {
        // Arrange
        Quarto quarto = new Quarto();
        quarto.setId(1L);
        quarto.setIdPredio(10L);
        quarto.setTipoQuarto(TipoQuarto.STANDARD_DUPLO);
        quarto.setCapacidadePessoas(1);
        quarto.setQtdeCamas("1");
        quarto.setValorDiaria(50.0);
        List<Movel> moveis = new ArrayList<>();
        Movel movel1 = new Movel();
        movel1.setId(1L);
        movel1.setDescricao("Test Bed");
        moveis.add(movel1);
        quarto.setMoveis(moveis);

        // Act
        QuartoResponseDTO responseDTO = mapper.convertToQuartoResponseDTO(quarto);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(quarto.getId(), responseDTO.getId());
        assertEquals(quarto.getIdPredio(), responseDTO.getIdPredio());
        assertEquals(quarto.getTipoQuarto(), responseDTO.getTipoQuarto());
        assertEquals(quarto.getCapacidadePessoas(), responseDTO.getCapacidadePessoas());
        assertEquals(quarto.getQtdeCamas(), responseDTO.getQtdeCamas());
        assertEquals(quarto.getValorDiaria(), responseDTO.getValorDiaria());
        assertEquals(quarto.getMoveis(), responseDTO.getMoveis());
    }

    @Test
    public void testConvertToQuarto() {
        // Arrange
        QuartoResponseDTO responseDTO = new QuartoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setIdPredio(10L);
        responseDTO.setTipoQuarto(TipoQuarto.STANDARD_DUPLO);
        responseDTO.setCapacidadePessoas(1);
        responseDTO.setQtdeCamas("1");
        responseDTO.setValorDiaria(50.0);
        List<Movel> moveis = new ArrayList<>();
        Movel movel1 = new Movel();
        movel1.setId(1L);
        movel1.setDescricao("Test Bed");
        moveis.add(movel1);
        responseDTO.setMoveis(moveis);

        // Act
        Quarto quarto = mapper.convertToQuarto(responseDTO);

        // Assert
        assertNotNull(quarto);
        assertEquals(responseDTO.getId(), quarto.getId());
        assertEquals(responseDTO.getIdPredio(), quarto.getIdPredio());
        assertEquals(responseDTO.getTipoQuarto(), quarto.getTipoQuarto());
        assertEquals(responseDTO.getCapacidadePessoas(), quarto.getCapacidadePessoas());
        assertEquals(responseDTO.getQtdeCamas(), quarto.getQtdeCamas());
        assertEquals(responseDTO.getValorDiaria(), quarto.getValorDiaria());
        assertEquals(responseDTO.getMoveis(), quarto.getMoveis());
    }
}
