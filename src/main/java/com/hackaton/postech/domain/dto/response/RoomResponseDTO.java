package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.enums.TypeRoom;
import com.hackaton.postech.domain.model.Room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDTO {

    private Long roomId;
    private BuildingResponseDTO building;
    private String typeRoom;
    private int peopleCapacity;
    private String amountBeds;
    private double dailyValue;
    private List<MobileResponseDTO> mobiles;

//    public static RoomResponseDTO of(Room quarto) {
//        var response = new RoomResponseDTO();
//        copyProperties(quarto, response);
//
//        // Convertendo a lista de Movel para List<MovelResponseDTO>
//        List<MobileResponseDTO> moveisResponseDTO = quarto.getMoveis().stream()
//                .map(MobileResponseDTO::of)
//                .collect(Collectors.toList());
//
//        response.setMoveis(moveisResponseDTO);
//
//        return response;
//    }
}
