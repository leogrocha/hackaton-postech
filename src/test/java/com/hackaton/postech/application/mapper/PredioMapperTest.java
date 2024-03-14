package com.hackaton.postech.application.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.enums.TipoQuarto;
import com.hackaton.postech.domain.model.Predio;
import com.hackaton.postech.domain.model.Quarto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class PredioMapperTest {

    private PredioMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(PredioMapper.class);
    }

    @Test
    public void testConvertToPredioResponseDTO() {
        // Arrange
        Predio predio = new Predio();
        predio.setId(1L);
        predio.setNome("Test Building");
        predio.setIdLocalidade(100L);
        List<Quarto> quartos = new ArrayList<>();
        Quarto quarto1 = new Quarto();
        quarto1.setId(1L);
        quarto1.setIdPredio(1L);
        quarto1.setTipoQuarto(TipoQuarto.STANDARD_DUPLO);
        quarto1.setCapacidadePessoas(TipoQuarto.STANDARD_DUPLO.getCapacidadePessoas());
        quarto1.setQtdeCamas(TipoQuarto.STANDARD_DUPLO.getQtdeCamas());
        quarto1.setValorDiaria(TipoQuarto.STANDARD_DUPLO.getValorDiaria());
        quartos.add(quarto1);
        predio.setQuartos(quartos);

        // Act
        PredioResponseDTO responseDTO = mapper.convertToPredioResponseDTO(predio);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(predio.getId(), responseDTO.getId());
        assertEquals(predio.getNome(), responseDTO.getNome());
        assertEquals(predio.getIdLocalidade(), responseDTO.getIdLocalidade());
        assertEquals(predio.getQuartos(), responseDTO.getQuartos());
    }

    @Test
    public void testConvertToPredio() {
        // Arrange
        PredioRequestDTO requestDTO = new PredioRequestDTO();
        requestDTO.setNome("Test Building");
        requestDTO.setIdLocalidade(100L);



        // Act
        Predio predio = mapper.convertToPredio(requestDTO);

        // Assert
        assertNotNull(predio);
        assertEquals(requestDTO.getNome(), predio.getNome());
        assertEquals(requestDTO.getIdLocalidade(), predio.getIdLocalidade());

    }

    @Test
    public void testConvertToPredioWithId() {
        // Arrange
        PredioRequestDTO requestDTO = new PredioRequestDTO();
        requestDTO.setNome("Test Building");
        requestDTO.setIdLocalidade(100L);
        Long id = 1L;


        // Act
        Predio predio = mapper.convertToPredioWithId(requestDTO, id);

        // Assert
        assertNotNull(predio);
        assertEquals(id, predio.getId());
        assertEquals(requestDTO.getNome(), predio.getNome());
        assertEquals(requestDTO.getIdLocalidade(), predio.getIdLocalidade());

    }
}

