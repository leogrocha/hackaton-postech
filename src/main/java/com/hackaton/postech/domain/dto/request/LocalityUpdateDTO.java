package com.hackaton.postech.domain.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocalityUpdateDTO {

        Long LocalityId;

        @NotBlank(message = "Nome não pode ser nulo ou em branco")
        private String name;

}
