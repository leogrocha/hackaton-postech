package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Endereco;
import com.hackaton.postech.domain.model.Localidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadeResponseDTO {

    private Long id;
    private String nome;
    private EnderecoResponseDTO endereco;

    public static LocalidadeResponseDTO of(Localidade request) {
        var response = new LocalidadeResponseDTO();
        copyProperties(request, response);

        // Copiar as propriedades do Endereco para o EnderecoResponseDTO
        EnderecoResponseDTO enderecoResponseDTO = EnderecoResponseDTO.of(request.getEndereco());
        response.setEndereco(enderecoResponseDTO);

        return response;
    }


}
