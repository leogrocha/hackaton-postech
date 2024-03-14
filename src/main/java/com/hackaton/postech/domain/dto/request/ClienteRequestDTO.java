package com.hackaton.postech.domain.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ClienteRequestDTO {

  @NotBlank(message = "Pais de origem não pode ser nulo ou em branco")
  private String paisOrigem;

  @NotBlank(message = "CPF não pode ser nulo ou em branco")
  @CPF(message = "CPF inválido")
  private String cpf;

  private String passaporte;

  @NotBlank(message = "Nome  não pode ser nulo ou em branco")
  private String nome;

  @NotNull(message = "Data de nascimento  não pode ser nulo ou em branco")
  private LocalDate dataNascimento;

  @NotBlank(message = "Telefone não pode ser nulo ou em branco")
  private String telefone;

  @NotBlank(message = "E-mail não pode ser nulo ou em branco")
  @Email(message = "E-mail inválido")
  private String email;

  @NotNull(message = "Endereço é obrigatório")
  @Valid private EnderecoRequestDTO endereco;

}
