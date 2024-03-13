package com.hackaton.postech.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovelRequestDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

}
