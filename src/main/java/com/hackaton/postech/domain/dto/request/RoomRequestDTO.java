package com.hackaton.postech.domain.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDTO {

    @Valid
    @NotNull(message = "Prédio obrigatório")
    private BuildingRequestDTO building;

    @NotBlank(message = "Tipo de quarto é obrigatório")
    private String typeRoom;

    private int peopleCapacity;
    private String amountBeds;
    private double dailyValue;
    private List<MobileRequestDTO> mobiles;

}
