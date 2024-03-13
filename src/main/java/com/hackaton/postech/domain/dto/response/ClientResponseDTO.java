package com.hackaton.postech.domain.dto.response;

import lombok.*;

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
  //    private Address address;
  private String phone;
  private String email;
}
