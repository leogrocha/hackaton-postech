package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
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
public class LocalidadeResponseDTO {

    private Long id;
    private String nome;
    private EnderecoResponseDTO endereco;
    private List<AmenidadeResponseDTO> amenidades;

}
