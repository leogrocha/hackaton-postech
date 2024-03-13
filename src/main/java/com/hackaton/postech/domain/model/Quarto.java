package com.hackaton.postech.domain.model;

import com.hackaton.postech.application.mapper.PredioMapper;
import com.hackaton.postech.application.mapper.QuartoMapper;
import com.hackaton.postech.domain.dto.request.QuartoRequestDTO;
import com.hackaton.postech.domain.enums.TipoQuarto;
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

    @ManyToOne
    @JoinColumn(name = "predio_id")
    private Predio predio;

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

    @Override
    public String toString() {
        return "Quarto{" +
                "id=" + id +
                ", predio=" + predio +
                ", tipoQuarto=" + tipoQuarto +
                ", totalPessoas=" + capacidadePessoas +
                ", totalCamas='" + qtdeCamas + '\'' +
                ", valorDiaria=" + valorDiaria +
                '}';
    }

    public Quarto(QuartoRequestDTO quartoRequestDTO) {
        this.predio = PredioMapper.INSTANCE.convertToPredio(quartoRequestDTO.getPredio());
        this.tipoQuarto = quartoRequestDTO.getTipoQuarto();
        this.capacidadePessoas = this.tipoQuarto.getCapacidadePessoas();
        this.qtdeCamas = this.tipoQuarto.getQtdeCamas();
        this.valorDiaria = this.tipoQuarto.getValorDiaria();
        this.moveis = this.tipoQuarto.getMoveis();
    }

}

