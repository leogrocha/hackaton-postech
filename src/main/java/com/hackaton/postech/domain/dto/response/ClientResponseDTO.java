package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import com.hackaton.postech.domain.model.Client;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"clientId"})
@ToString
@Getter
@Setter
public class ClientResponseDTO {

  private Long clientId;
  private String countryOfOrigin;
  private String document;
  private String passport;
  private String name;
  private LocalDate birthDate;
  private String phone;
  private String email;
  private AddressResponseDTO address;

  public static ClientResponseDTO of(Client client) {
    var clientResponseDTO = new ClientResponseDTO();
    clientResponseDTO.setAddress(AddressResponseDTO.of(client.getAddress()));
    BeanUtils.copyProperties(client, clientResponseDTO);
    return clientResponseDTO;
  }
}
