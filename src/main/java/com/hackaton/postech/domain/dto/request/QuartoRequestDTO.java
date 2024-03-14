package com.hackaton.postech.domain.dto.request;

import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.domain.enums.TipoQuarto;
import com.hackaton.postech.domain.model.Movel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuartoRequestDTO {

    @NotNull(message = "Prédio é obrigatório")
    private Long idPredio;

    @NotNull(message = "Tipo de quarto é obrigatório")
    private TipoQuarto tipoQuarto;

    private int capacidadePessoas;
    private String qtdeCamas;
    private double valorDiaria;
    private List<MovelRequestDTO> moveis;

}
