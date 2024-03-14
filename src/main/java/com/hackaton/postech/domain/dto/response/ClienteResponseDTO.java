package com.hackaton.postech.domain.dto.response;

import java.time.LocalDate;

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
