package com.hackaton.postech.domain.enums;

import com.hackaton.postech.domain.model.Movel;
import com.hackaton.postech.useCase.implementation.MovelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public enum TipoQuarto {

    STANDARD_SIMPLES(2, "1 x Queen Size", getMoveisPadrao(), "Simple (Box com Ducha, Privada, Ducha higiênica e pia com espelho)", 350.00, 20),
    STANDARD_DUPLO(4, "1 x Queen Size e 2 x Solteiro", getMoveisPadrao(), "Simple (Box com Ducha, Privada, Ducha higiênica e pia com espelho)", 450.00, 15),
    LUXO_SIMPLES(2, "1 x King Size", getMoveisPadrao(), "Luxo (Box com Ducha, Privada, Ducha higiênica e pia dupla com espelho)", 550.00, 20),
    LUXO_DUPLO(4, "1 x King Size e 2 x Solteiro", getMoveisPadrao(), "Luxo (Box com Ducha, Privada, Ducha higiênica e pia dupla com espelho)", 650.00, 15),
    PREMIUM_SIMPLES(2, "1 x King Size", getMoveisPadrao(), "Premium (Box com Ducha, Privada, Ducha higiênica, pia dupla com espelho e Sauna)", 850.00, 10),
    PREMIUM_DUPLO(4, "2 x King Size", getMoveisPadrao(), "Premium (Box com Ducha, Privada, Ducha higiênica, pia dupla com espelho e Sauna)", 950.00, 5);

    private final int capacidadePessoas;
    private final String qtdeCamas;
    private final List<Movel> moveis;
    private final String tipoBanheiro;
    private final double valorDiaria;
    private final int quantidadeQuartos;


    TipoQuarto(int capacidadePessoas, String qtdeCamas, List<Movel> moveis, String tipoBanheiro, double valorDiaria, int quantidadeQuartos) {
        this.capacidadePessoas = capacidadePessoas;
        this.qtdeCamas = qtdeCamas;
        this.moveis = moveis;
        this.tipoBanheiro = tipoBanheiro;
        this.valorDiaria = valorDiaria;
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    public String getQtdeCamas() {
        return qtdeCamas;
    }

    public List<Movel> getMoveis() {
        return moveis;
    }

    public String getTipoBanheiro() {
        return tipoBanheiro;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    private List<Movel> getMoveisPadrao(MovelService movelService) {
        // Chamar o serviço MovelService para obter ou criar móveis padrão
        return movelService.obterOuCriarMoveisPadrao(Arrays.asList("Sofá", "Poltronas", "Frigobar", "TV Led 54 pols.", "Mesa de Escritório", "Cadeira de Escritório"));
    }
}
