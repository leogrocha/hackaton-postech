package com.hackaton.postech.domain.dto.request;

import com.hackaton.postech.domain.dto.response.BuildingResponseDTO;
import com.hackaton.postech.domain.model.Building;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildingUpdateDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    public static BuildingUpdateDTO of(Building building) {
        var buildingUpdateDTO = new BuildingUpdateDTO();
        BeanUtils.copyProperties(building, buildingUpdateDTO);
        return buildingUpdateDTO;
    }

}
