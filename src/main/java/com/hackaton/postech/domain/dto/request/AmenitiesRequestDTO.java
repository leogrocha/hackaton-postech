package com.hackaton.postech.domain.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AmenitiesRequestDTO {

    @NotBlank(message = "Descrição não pode ser nulo ou em branco")
    private String description;

    @Valid @NotNull(message = "Localidade não pode ser nulo ou em branco")
    private LocalityRequestDTO locality;

}
