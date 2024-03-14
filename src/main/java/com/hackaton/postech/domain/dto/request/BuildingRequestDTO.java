package com.hackaton.postech.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildingRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotNull(message = "Localidade é obrigatória")
    private LocalityRequestDTO locality;

}
