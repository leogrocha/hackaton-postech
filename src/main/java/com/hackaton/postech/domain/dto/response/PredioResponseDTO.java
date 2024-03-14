package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Predio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredioResponseDTO {

    private Long id;
    private String nome;
    private Long idLocalidade;
    private List<QuartoResponseDTO> quartos;


}
