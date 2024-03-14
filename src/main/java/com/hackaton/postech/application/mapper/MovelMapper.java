package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.domain.model.Movel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MovelMapper {

    @Mapping(target = "id", source = "movel.id")
    @Mapping(target = "descricao", source = "movel.descricao")
    MovelResponseDTO convertToMovelResponseDTO(Movel movel);

    @Mapping(target = "descricao", source = "movelRequest.descricao")
    Movel convertToMovel(MovelRequestDTO movelRequest);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "descricao", source = "movelRequest.descricao")
    Movel convertToMovelWithId(MovelRequestDTO movelRequest, Long id);
}
