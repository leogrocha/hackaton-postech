package com.hackaton.postech.domain.dto.request;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;

public class ServicosRequestDTO {

  @NotBlank(message = "descricao é obrigatório")
  private String descricao;

  @Negative(message = "Valor não pode ser negativo")
  @NotBlank(message = "descricao é obrigatório")
  private Double valor;
}
