package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Mobile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileResponseDTO {

    private Long mobileId;
    private String description;

//    public static MobileResponseDTO of(Mobile request) {
//        var response = new MobileResponseDTO();
//        copyProperties(request, response);
//        return response;
//    }
}
