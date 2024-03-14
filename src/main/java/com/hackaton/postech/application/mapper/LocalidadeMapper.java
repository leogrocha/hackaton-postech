package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalidadeResponseDTO;
import com.hackaton.postech.domain.model.Localidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface LocalidadeMapper {

    @Mapping(target = "id", source = "localidade.id")
    @Mapping(target = "nome", source = "localidade.nome")
    @Mapping(target = "endereco", source = "localidade.endereco")
    @Mapping(target = "amenidades", source = "localidade.amenidades" )
    LocalidadeResponseDTO convertToLocalidadeResponseDTO(Localidade localidade);

    @Mapping(target = "id", source = "localidadeResponse.id")
    @Mapping(target = "nome", source = "localidadeResponse.nome")
    @Mapping(target = "endereco", source = "localidadeResponse.endereco")
    @Mapping(target = "amenidades", source = "localidadeResponse.amenidades" )
    Localidade convertToLocalidade(LocalidadeResponseDTO localidadeResponse);
}
