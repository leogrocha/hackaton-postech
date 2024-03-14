package com.hackaton.postech.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO {

  private Long id;
  private String paisOrigem;
  private String cpf;
  private String passaporte;
  private String nome;
  private LocalDate dataNascimento;
  private String telefone;
  private String email;
  private EnderecoResponseDTO endereco;

}
