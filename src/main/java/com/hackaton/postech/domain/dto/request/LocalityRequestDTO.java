package com.hackaton.postech.domain.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocalityRequestDTO {

        Long LocalityId;

        @NotBlank(message = "Nome não pode ser nulo ou em branco")
        private String name;

        @Valid
        @NotNull(message = "Endereço não pode ser nulo ou em branco")
        private AddressRequestDTO address;

}
