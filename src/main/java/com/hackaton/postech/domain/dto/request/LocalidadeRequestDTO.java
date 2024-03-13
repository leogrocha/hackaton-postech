package com.hackaton.postech.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocalidadeRequestDTO {

        @NotBlank(message = "Nome é obrigatório")
        private String nome;

        @NotNull(message = "Endereço é obrigatório")
        private EnderecoRequestDTO endereco;

}
