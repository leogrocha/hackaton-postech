package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.enums.TipoQuarto;
import com.hackaton.postech.domain.model.Quarto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuartoResponseDTO {

    private Long id;
    private PredioResponseDTO predio;
    private TipoQuarto tipoQuarto;
    private int capacidadePessoas;
    private String qtdeCamas;
    private double valorDiaria;
    private List<MovelResponseDTO> moveis;

    public static QuartoResponseDTO of(Quarto quarto) {
        var response = new QuartoResponseDTO();
        copyProperties(quarto, response);

        // Convertendo a lista de Movel para List<MovelResponseDTO>
        List<MovelResponseDTO> moveisResponseDTO = quarto.getMoveis().stream()
                .map(MovelResponseDTO::of)
                .collect(Collectors.toList());

        response.setMoveis(moveisResponseDTO);

        return response;
    }
}
