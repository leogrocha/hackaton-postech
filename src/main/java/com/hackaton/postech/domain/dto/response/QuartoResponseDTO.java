package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.enums.TipoQuarto;
import com.hackaton.postech.domain.model.Movel;
import com.hackaton.postech.domain.model.Quarto;

import com.hackaton.postech.useCase.implementation.MovelService;
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
    private Long idPredio;
    private TipoQuarto tipoQuarto;
    private int capacidadePessoas;
    private String qtdeCamas;
    private double valorDiaria;
    private List<Movel> moveis;

    public QuartoResponseDTO (QuartoRequestDTO quartoRequestDTO) {
        this.idPredio = quartoRequestDTO.getIdPredio();
        this.tipoQuarto = quartoRequestDTO.getTipoQuarto();
        this.capacidadePessoas = this.tipoQuarto.getCapacidadePessoas();
        this.qtdeCamas = this.tipoQuarto.getQtdeCamas();
        this.valorDiaria = this.tipoQuarto.getValorDiaria();
        this.moveis = MovelService.obterOuCriarMoveisPadrao(this.tipoQuarto.getMoveis());
    }
}
