package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import com.hackaton.postech.domain.dto.response.PredioResponseDTO;
import com.hackaton.postech.domain.model.Predio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PredioMapper {

    PredioMapper INSTANCE = Mappers.getMapper(PredioMapper.class);

    @Mapping(target = "id", source = "predio.id")
    @Mapping(target = "nome", source = "predio.nome")
    @Mapping(target = "localidade", source = "predio.localidade")
    PredioResponseDTO convertToPredioResponseDTO(Predio predio);

    @Mapping(target = "nome", source = "predioRequest.nome")
    @Mapping(target = "localidade", source = "predioRequest.localidade")
    Predio convertToPredio(PredioRequestDTO predioRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "predioRequest.nome")
    @Mapping(target = "localidade", source = "predioRequest.localidade")
    Predio convertToPredioWithId(PredioRequestDTO predioRequest, Long id);
}
