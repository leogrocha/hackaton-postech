package com.hackaton.postech.domain.model;

import com.hackaton.postech.application.mapper.PredioMapper;
import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.dto.response.QuartoResponseDTO;
import com.hackaton.postech.domain.enums.TipoQuarto;
import com.hackaton.postech.useCase.implementation.MovelService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quartos")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_predio")
    private Long idPredio;

    @Column(name = "tipo_quarto")
    @Enumerated(EnumType.STRING)
    private TipoQuarto tipoQuarto;

    @Column(name = "capacidade_pessoas")
    private int capacidadePessoas;

    @Column(name = "qtde_camas")
    private String qtdeCamas;

    @Column(name = "valor_diaria")
    private double valorDiaria;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quarto_id")
    private List<Movel> moveis;

    public Quarto(QuartoRequestDTO quartoRequestDTO) {
        this.idPredio = quartoRequestDTO.getIdPredio();
        this.tipoQuarto = quartoRequestDTO.getTipoQuarto();
        this.capacidadePessoas = this.tipoQuarto.getCapacidadePessoas();
        this.qtdeCamas = this.tipoQuarto.getQtdeCamas();
        this.valorDiaria = this.tipoQuarto.getValorDiaria();
        this.moveis = MovelService.obterOuCriarMoveisPadrao(this.tipoQuarto.getMoveis());
    }
}

