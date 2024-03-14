package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Amenidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmenidadeResponseDTO {

    private Long id;
    private String descricao;
    private Long idLocalidade;

}
