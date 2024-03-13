package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Predio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredioResponseDTO {

    private Long id;
    private String nome;
    private LocalidadeResponseDTO localidade;

    public static PredioResponseDTO of(Predio request) {
        var response = new PredioResponseDTO();
        copyProperties(request, response);

        // Copiar as propriedades do Localidade para o LocalidadeResponseDTO
        LocalidadeResponseDTO localidadeResponseDTO = LocalidadeResponseDTO.of(request.getLocalidade());
        response.setLocalidade(localidadeResponseDTO);
        return response;
    }


}
