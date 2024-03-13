package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.dto.response.ClientResponseDTO;
import com.hackaton.postech.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  @Mapping(target = "clientId", source = "client.clientId")
  @Mapping(target = "countryOfOrigin", source = "client.countryOfOrigin")
  @Mapping(target = "document", source = "client.document")
  @Mapping(target = "passport", source = "client.passport")
  @Mapping(target = "name", source = "client.name")
  @Mapping(target = "birthDate", source = "client.birthDate")
//  @Mapping(target = "address", source = "client.address")
  @Mapping(target = "phone", source = "client.phone")
  @Mapping(target = "email", source = "client.email")
  ClientResponseDTO convertToClientResponse(Client client);

  @Mapping(target = "countryOfOrigin", source = "clientRequest.countryOfOrigin")
  @Mapping(target = "document", source = "clientRequest.document")
  @Mapping(target = "passport", source = "clientRequest.passport")
  @Mapping(target = "name", source = "clientRequest.name")
  @Mapping(target = "birthDate", source = "clientRequest.birthDate")
//  @Mapping(target = "address", source = "clientRequest.address")
  @Mapping(target = "phone", source = "clientRequest.phone")
  @Mapping(target = "email", source = "clientRequest.email")
  Client convertToClient(ClientRequestDTO clientRequest);

//  @Mapping(target = "countryOfOrigin", source = "client.countryOfOrigin")
//  @Mapping(target = "document", source = "client.document")
//  @Mapping(target = "passport", source = "client.passport")
//  @Mapping(target = "name", source = "client.name")
//  @Mapping(target = "birthDate", source = "client.birthDate")
////  @Mapping(target = "address", source = "client.passaport")
//  @Mapping(target = "phone", source = "client.phone")
//  @Mapping(target = "email", source = "client.email")
//  ClientRequestDTO convertToClientRequest(Client client);

}
