package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Quarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface QuartoMapper {

    @Mapping(target = "id", source = "quarto.id")
    @Mapping(target = "idPredio", source = "quarto.idPredio")
    @Mapping(target = "tipoQuarto", source = "quarto.tipoQuarto")
    @Mapping(target = "capacidadePessoas", source = "quarto.capacidadePessoas")
    @Mapping(target = "qtdeCamas", source = "quarto.qtdeCamas")
    @Mapping(target = "valorDiaria", source = "quarto.valorDiaria")
    @Mapping(target = "moveis", source = "quarto.moveis")
    QuartoResponseDTO convertToQuartoResponseDTO(Quarto quarto);

    @Mapping(target = "id", source = "quartoResponse.id")
    @Mapping(target = "idPredio", source = "quartoResponse.idPredio")
    @Mapping(target = "tipoQuarto", source = "quartoResponse.tipoQuarto")
    @Mapping(target = "capacidadePessoas", source = "quartoResponse.capacidadePessoas")
    @Mapping(target = "qtdeCamas", source = "quartoResponse.qtdeCamas")
    @Mapping(target = "valorDiaria", source = "quartoResponse.valorDiaria")
    @Mapping(target = "moveis", source = "quartoResponse.moveis")
    Quarto convertToQuarto(QuartoResponseDTO quartoResponse);

}
