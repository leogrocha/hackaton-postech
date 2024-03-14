package com.hackaton.postech.application.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.domain.model.Amenidade;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class LocalidadeMapperTest {

    private LocalidadeMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(LocalidadeMapper.class);
    }

    @Test
    public void testConvertToLocalidadeResponseDTO() {
        // Arrange
        Localidade localidade = new Localidade();
        localidade.setId(1L);
        localidade.setNome("Test Location");
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setRua("Test Street");
        endereco.setNumero(1);
        endereco.setBairro("Test Neighborhood");
        endereco.setCidade("Test City");
        endereco.setEstado("Test State");
        localidade.setEndereco(endereco);
        List<Amenidade> amenidades = new ArrayList<>();
        Amenidade amenidade1 = new Amenidade();
        amenidade1.setId(1L);
        amenidade1.setDescricao("Test Amenity 1");
        amenidades.add(amenidade1);
        localidade.setAmenidades(amenidades);

        // Act
        LocalidadeResponseDTO responseDTO = mapper.convertToLocalidadeResponseDTO(localidade);

        // Assert
        assertNotNull(responseDTO);
        assertEquals(localidade.getId(), responseDTO.getId());
        assertEquals(localidade.getNome(), responseDTO.getNome());
        assertEquals(localidade.getEndereco(), responseDTO.getEndereco());
        assertEquals(localidade.getAmenidades(), responseDTO.getAmenidades());
    }

    @Test
    public void testConvertToLocalidade() {
        // Arrange
        LocalidadeResponseDTO responseDTO = new LocalidadeResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setNome("Test Location");
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setRua("Test Street");
        endereco.setNumero(123);
        endereco.setBairro("Test Neighborhood");
        endereco.setCidade("Test City");
        endereco.setEstado("Test State");
        responseDTO.setEndereco(EnderecoResponseDTO.of(endereco));
        List<AmenidadeResponseDTO> amenidades = new ArrayList<>();
        AmenidadeResponseDTO amenidade1 = new AmenidadeResponseDTO();
        amenidade1.setId(1L);
        amenidade1.setDescricao("Test Amenity 1");
        amenidades.add(amenidade1);
        responseDTO.setAmenidades(amenidades);

        // Act
        Localidade localidade = mapper.convertToLocalidade(responseDTO);

        // Assert
        assertNotNull(localidade);
        assertEquals(responseDTO.getId(), localidade.getId());
        assertEquals(responseDTO.getNome(), localidade.getNome());
        assertEquals(responseDTO.getEndereco(), localidade.getEndereco());
        assertEquals(responseDTO.getAmenidades(), localidade.getAmenidades());
    }
}
