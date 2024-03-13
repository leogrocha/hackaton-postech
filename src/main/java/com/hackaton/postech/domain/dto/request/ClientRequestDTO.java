package com.hackaton.postech.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {

//  final String complement = "não pode ser nulo ou em branco";

  @NotBlank(message = "Pais de origem não pode ser nulo ou em branco")
  private String countryOfOrigin;

  @NotBlank(message = "CPF não pode ser nulo ou em branco")
  @CPF(message = "CPF inválido")
  private String document;

  private String passport;

  @NotBlank(message = "Nome  não pode ser nulo ou em branco")
  private String name;

  @NotNull(message = "Data de nascimento  não pode ser nulo ou em branco")
  private String birthDate;
  //    private Address address;
  @NotBlank(message = "Telefone não pode ser nulo ou em branco")
  private String phone;

  @NotBlank(message = "E-mail não pode ser nulo ou em branco")
  @Email(message = "E-mail inválido")
  private String email;

}
