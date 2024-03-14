package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.EnderecoRequestDTO;
import com.hackaton.postech.domain.dto.response.EnderecoResponseDTO;
import com.hackaton.postech.domain.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "id", source = "endereco.id")
    @Mapping(target = "rua", source = "endereco.rua")
    @Mapping(target = "numero", source = "endereco.numero")
    @Mapping(target = "bairro", source = "endereco.bairro")
    @Mapping(target = "cidade", source = "endereco.cidade")
    @Mapping(target = "estado", source = "endereco.estado")
    EnderecoResponseDTO convertToEnderecoResponseDTO(Endereco endereco);

    @Mapping(target = "rua", source = "enderecoRequest.rua")
    @Mapping(target = "numero", source = "enderecoRequest.numero")
    @Mapping(target = "bairro", source = "enderecoRequest.bairro")
    @Mapping(target = "cidade", source = "enderecoRequest.cidade")
    @Mapping(target = "estado", source = "enderecoRequest.estado")
    Endereco convertToEndereco(EnderecoRequestDTO enderecoRequest);

    @Mapping(target = "id", source = "enderecoResponse.id")
    @Mapping(target = "rua", source = "enderecoResponse.rua")
    @Mapping(target = "numero", source = "enderecoResponse.numero")
    @Mapping(target = "bairro", source = "enderecoResponse.bairro")
    @Mapping(target = "cidade", source = "enderecoResponse.cidade")
    @Mapping(target = "estado", source = "enderecoResponse.estado")
    Endereco convertToEndereco(EnderecoResponseDTO enderecoResponse);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "rua", source = "enderecoRequest.rua")
    @Mapping(target = "numero", source = "enderecoRequest.numero")
    @Mapping(target = "bairro", source = "enderecoRequest.bairro")
    @Mapping(target = "cidade", source = "enderecoRequest.cidade")
    @Mapping(target = "estado", source = "enderecoRequest.estado")
    Endereco convertToEnderecoWithId(EnderecoRequestDTO enderecoRequest, Long id);




}
