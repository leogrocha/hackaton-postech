package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.dto.request.ItensRequestDTO;
import com.hackaton.postech.domain.dto.request.ServicosRequestDTO;
import com.hackaton.postech.domain.model.Quarto;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaResponseDTO {

  @NotNull(message = "Cliente é obrigatório")
  private ClienteResponseDTO cliente;

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
