package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.model.Quarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface QuartoMapper {

    @Mapping(target = "id", source = "quarto.id")
    @Mapping(target = "predio", source = "quarto.predio")
    @Mapping(target = "tipoQuarto", source = "quarto.tipoQuarto")
    @Mapping(target = "capacidadePessoas", source = "quarto.capacidadePessoas")
    @Mapping(target = "qtdeCamas", source = "quarto.qtdeCamas")
    @Mapping(target = "valorDiaria", source = "quarto.valorDiaria")
    @Mapping(target = "moveis", source = "quarto.moveis")
    QuartoResponseDTO convertToQuartoResponseDTO(Quarto quarto);

    Quarto convertToQuarto(QuartoRequestDTO quartoRequest);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "predio", source = "quartoRequest.predio")
    @Mapping(target = "tipoQuarto", source = "quartoRequest.tipoQuarto")
    @Mapping(target = "capacidadePessoas", source = "quartoRequest.capacidadePessoas")
    @Mapping(target = "qtdeCamas", source = "quartoRequest.qtdeCamas")
    @Mapping(target = "valorDiaria", source = "quartoRequest.valorDiaria")
    @Mapping(target = "moveis", source = "quartoRequest.moveis")
    Quarto convertToQuartoWithId(QuartoRequestDTO quartoRequest, Long id);
}
