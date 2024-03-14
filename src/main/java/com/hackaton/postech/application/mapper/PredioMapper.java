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

    @Mapping(target = "id", source = "predio.id")
    @Mapping(target = "nome", source = "predio.nome")
    @Mapping(target = "idLocalidade", source = "predio.idLocalidade")
    @Mapping(target = "quartos", source = "predio.quartos")
    PredioResponseDTO convertToPredioResponseDTO(Predio predio);

    @Mapping(target = "nome", source = "predioRequest.nome")
    @Mapping(target = "idLocalidade", source = "predioRequest.idLocalidade")
    Predio convertToPredio(PredioRequestDTO predioRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "predioRequest.nome")
    @Mapping(target = "idLocalidade", source = "predioRequest.idLocalidade")
    Predio convertToPredioWithId(PredioRequestDTO predioRequest, Long id);
}
