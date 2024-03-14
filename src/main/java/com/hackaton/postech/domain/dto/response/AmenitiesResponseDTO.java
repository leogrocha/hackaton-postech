package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Amenities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmenitiesResponseDTO {

    private Long amenitiesId;
    private String description;
    private LocalityResponseDTO locality;

//    public static AmenitiesResponseDTO of(Amenities request) {
//        var response = new AmenitiesResponseDTO();
//        copyProperties(request, response);
//
//        // Copiar as propriedades do Localidade para o LocalidadeResponseDTO
//        LocalityResponseDTO localidadeResponseDTO = LocalityResponseDTO.of(request.getLocalidade());
//        response.setLocalidade(localidadeResponseDTO);
//        return response;
//    }


}
