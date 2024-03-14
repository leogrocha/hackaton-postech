package com.hackaton.postech.domain.dto.request;

import com.hackaton.postech.domain.dto.response.ClienteResponseDTO;
import com.hackaton.postech.domain.model.Quarto;
import com.hackaton.postech.domain.model.Servicos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservaRequestDTO {

  @NotNull(message = "Cliente é obrigatório")
  private ClienteRequestDTO cliente;

  @NotBlank(message = "Data da reserva é obrigatório")
  @PastOrPresent(message = "Data da reserva não pode ser retroativa")
  private LocalDateTime dataReserva;

  @NotNull(message = "Quarto é obrigatório")
  private Quarto quarto;

  @NotBlank(message = "Valor total é obrigatório")
  @Negative(message = "Valor total não pode ser negativo")
  private Double valorTotal;

  private boolean confirmacaoEmail;

  private List<ItensRequestDTO> itens;
  private List<ServicosRequestDTO> servicos;


}
