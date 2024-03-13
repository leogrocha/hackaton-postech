package com.hackaton.postech.domain.dto.request;

import com.hackaton.postech.domain.dto.response.MovelResponseDTO;
import com.hackaton.postech.domain.enums.TipoQuarto;
import com.hackaton.postech.domain.model.Movel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Prédio é obrigatório")
    private PredioRequestDTO predio;

    @NotBlank(message = "Tipo de quarto é obrigatório")
    private TipoQuarto tipoQuarto;

    private int capacidadePessoas;
    private String qtdeCamas;
    private double valorDiaria;
    private List<MovelRequestDTO> moveis;

}
