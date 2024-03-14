package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.ReservaRequestDTO;
import com.hackaton.postech.domain.dto.request.ServicosRequestDTO;
import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.dto.response.ReservaResponseDTO;
import com.hackaton.postech.domain.model.Cliente;
import com.hackaton.postech.domain.model.Reserva;
import com.hackaton.postech.domain.model.Servicos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface ReservaMapper {

  @Mapping(target = "id", source = "reserva.id")
  @Mapping(target = "cliente", source = "reserva.cliente")
  @Mapping(target = "dataReserva", source = "reserva.dataReserva")
  @Mapping(target = "quarto", source = "reserva.quarto")
  @Mapping(target = "valorTotal", source = "reserva.valorTotal")
  @Mapping(target = "confirmacaoEmail", source = "reserva.confirmacaoEmail")
  @Mapping(target = "itens", source = "reserva.itens")
  @Mapping(target = "servicos", source = "reserva.servicos")
  ReservaResponseDTO convertToReservaResponse(Reserva reserva);

  @Mapping(target = "cliente", source = "reservaRequestDTO.cliente")
  @Mapping(target = "dataReserva", source = "reservaRequestDTO.dataReserva")
  @Mapping(target = "quarto", source = "reservaRequestDTO.quarto")
  @Mapping(target = "valorTotal", source = "reservaRequestDTO.valorTotal")
  @Mapping(target = "confirmacaoEmail", source = "reservaRequestDTO.confirmacaoEmail")
  @Mapping(target = "itens", source = "reservaRequestDTO.itens")
  @Mapping(target = "servicos", source = "reservaRequestDTO.servicos")
  Reserva convertToReserva(ReservaRequestDTO reservaRequestDTO);

  default Set<ServicosRequestDTO> mapServicosToDTO(Set<Servicos> servicos) {
    return servicos.stream()
            .map(servico -> new ServicosRequestDTO(servico.getDescricao(), servico.getValor()))
            .collect(Collectors.toSet());
  }
}

