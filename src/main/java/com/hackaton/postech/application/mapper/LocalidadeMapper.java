package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.domain.model.Localidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocalidadeMapper {

    @Mapping(target = "id", source = "localidade.id")
    @Mapping(target = "nome", source = "localidade.nome")
    @Mapping(target = "endereco", source = "localidade.endereco")
    LocalidadeResponseDTO convertToLocalidadeResponseDTO(Localidade localidade);

    @Mapping(target = "nome", source = "localidadeRequest.nome")
    @Mapping(target = "endereco", source = "localidadeRequest.endereco")
    Localidade convertToLocalidade(LocalidadeRequestDTO localidadeRequest);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "localidadeRequest.nome")
    @Mapping(target = "endereco", source = "localidadeRequest.endereco")
    Localidade convertToLocalidadeWithId(LocalidadeRequestDTO localidadeRequest, Long id);
}
