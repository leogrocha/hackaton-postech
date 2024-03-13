package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.domain.model.Predio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PredioMapper {

    @Mapping(target = "id", source = "Predio.id")
    @Mapping(target = "nome", source = "Predio.nome")
    @Mapping(target = "localidade", source = "Predio.localidade")
    PredioResponseDTO convertToPredioResponseDTO(Predio predio);

    @Mapping(target = "nome", source = "predioRequest.nome")
    @Mapping(target = "localidade", source = "predioRequest.localidade")
    Predio convertToPredio(PredioRequestDTO predioRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "predioRequest.descricao")
    @Mapping(target = "localidade", source = "predioRequest.localidade")
    Predio convertToPredioWithId(PredioRequestDTO predioRequest, Long id);
}
