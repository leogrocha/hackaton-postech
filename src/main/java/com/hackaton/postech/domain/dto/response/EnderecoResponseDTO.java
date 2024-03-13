package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponseDTO {

    private Long id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    public static EnderecoResponseDTO of(Endereco request) {
        var response = new EnderecoResponseDTO();
        copyProperties(request, response);
        return response;
    }

}