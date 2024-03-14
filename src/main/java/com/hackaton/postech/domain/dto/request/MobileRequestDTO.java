package com.hackaton.postech.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MobileRequestDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

}
