package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.ClienteRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", source = "cliente.id")
    @Mapping(target = "paisOrigem", source = "cliente.paisOrigem")
    @Mapping(target = "cpf", source = "cliente.cpf")
    @Mapping(target = "passaporte", source = "cliente.passaporte")
    @Mapping(target = "nome", source = "cliente.nome")
    @Mapping(target = "dataNascimento", source = "cliente.dataNascimento")
    @Mapping(target = "telefone", source = "cliente.telefone")
    @Mapping(target = "email", source = "cliente.email")
    @Mapping(target = "endereco", source = "cliente.endereco")
    ClienteResponseDTO convertToClienteResponse(Cliente cliente);

    @Mapping(target = "paisOrigem", source = "clienteRequestDTO.paisOrigem")
    @Mapping(target = "cpf", source = "clienteRequestDTO.cpf")
    @Mapping(target = "passaporte", source = "clienteRequestDTO.passaporte")
    @Mapping(target = "nome", source = "clienteRequestDTO.nome")
    @Mapping(target = "dataNascimento", source = "clienteRequestDTO.dataNascimento")
    @Mapping(target = "telefone", source = "clienteRequestDTO.telefone")
    @Mapping(target = "email", source = "clienteRequestDTO.email")
    @Mapping(target = "endereco", source = "clienteRequestDTO.endereco")
    Cliente convertToCliente(ClienteRequestDTO clienteRequestDTO);


}
