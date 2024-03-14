package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenidadeResponseDTO;
import com.hackaton.postech.domain.model.Amenidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AmenidadeMapper {

    @Mapping(target = "id", source = "amenidade.id")
    @Mapping(target = "descricao", source = "amenidade.descricao")
    @Mapping(target = "idLocalidade", source = "amenidade.idLocalidade")
    AmenidadeResponseDTO convertToAmenidadeResponseDTO(Amenidade amenidade);


    @Mapping(target = "descricao", source = "amenidadeRequest.descricao")
    @Mapping(target = "idLocalidade", source = "amenidadeRequest.idLocalidade")
    Amenidade convertToAmenidade(AmenidadeRequestDTO amenidadeRequest);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "descricao", source = "amenidadeRequest.descricao")
    @Mapping(target = "idLocalidade", source = "amenidadeRequest.idLocalidade")
    Amenidade convertToAmenidadeWithId(AmenidadeRequestDTO amenidadeRequest, Long id);
}
