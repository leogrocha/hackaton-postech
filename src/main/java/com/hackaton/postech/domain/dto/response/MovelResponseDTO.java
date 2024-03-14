package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Movel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovelResponseDTO {

    private Long id;
    private String descricao;

    public static MovelResponseDTO of(Movel request) {
        var response = new MovelResponseDTO();
        copyProperties(request, response);
        return response;
    }
}
