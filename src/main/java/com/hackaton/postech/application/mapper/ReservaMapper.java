package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.dto.response.ReservaResponseDTO;
import com.hackaton.postech.domain.model.Cliente;
import com.hackaton.postech.domain.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

  @Mapping(target = "id", source = "reserva.id")
  @Mapping(target = "cliente", source = "reserva.cliente")
  @Mapping(target = "dataReserva", source = "reserva.dataReserva")
  @Mapping(target = "quarto", source = "reserva.quarto")
  @Mapping(target = "valorTotal", source = "reserva.valorTotal")
  @Mapping(target = "confirmacaoEmail", source = "reserva.confirmacaoEmail")
  @Mapping(target = "itens", source = "reserva.itens")
  @Mapping(target = "services", source = "reserva.services")
  ReservaResponseDTO convertToReservaResponse(Reserva reserva);
}
