package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Building;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildingResponseDTO {

    private Long buildingId;
    private String name;
    private LocalityResponseDTO locality;

    public static BuildingResponseDTO of(Building building) {
        var buildingResponseDTO = new BuildingResponseDTO();
        BeanUtils.copyProperties(building, buildingResponseDTO);
        return buildingResponseDTO;
    }


}
