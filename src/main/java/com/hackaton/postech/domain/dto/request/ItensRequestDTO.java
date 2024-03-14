package com.hackaton.postech.domain.dto.request;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItensRequestDTO {


  @NotBlank(message = "descricao é obrigatório")
  private String descricao;

  @Negative(message = "Valor não pode ser negativo")
  @NotBlank(message = "descricao é obrigatório")
  private Double valor;
}
