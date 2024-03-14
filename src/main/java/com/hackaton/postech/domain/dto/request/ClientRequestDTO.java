package com.hackaton.postech.domain.dto.request;

import com.hackaton.postech.domain.model.Address;
import com.hackaton.postech.domain.model.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
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
public class ClientRequestDTO {

  private Long clientId;

  @NotBlank(message = "Pais de origem não pode ser nulo ou em branco")
  private String countryOfOrigin;

  @NotBlank(message = "CPF não pode ser nulo ou em branco")
  @CPF(message = "CPF inválido")
  private String document;

  private String passport;

  @NotBlank(message = "Nome  não pode ser nulo ou em branco")
  private String name;

  @NotNull(message = "Data de nascimento  não pode ser nulo ou em branco")
  private LocalDate birthDate;

  @NotBlank(message = "Telefone não pode ser nulo ou em branco")
  private String phone;

  @NotBlank(message = "E-mail não pode ser nulo ou em branco")
  @Email(message = "E-mail inválido")
  private String email;


  @NotNull(message = "Endereço é obrigatório")
  @Valid private AddressRequestDTO address;

  public static void mapperEntity(ClientRequestDTO clientRequestDTO, Client client, Address address) {
    client.setName(clientRequestDTO.getName());
    client.setCountryOfOrigin(clientRequestDTO.getCountryOfOrigin());
    client.setDocument(clientRequestDTO.getDocument());
    client.setPassport(clientRequestDTO.getPassport());
    client.setBirthDate(clientRequestDTO.getBirthDate());
    client.setPhone(clientRequestDTO.getPhone());
    client.setEmail(clientRequestDTO.getEmail());
    client.setAddress(address);
  }

}
