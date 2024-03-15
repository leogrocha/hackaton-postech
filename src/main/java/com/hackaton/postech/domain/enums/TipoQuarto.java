package com.hackaton.postech.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum TipoQuarto {

    STANDARD_SIMPLES(2, "1 x Queen Size",
            Arrays.asList("Sofá", "Poltrona", "Frigobar", "TV Led 54 pols.", "Mesa de Escritório", "Cadeira de Escritório"),
            "Simple (Box com Ducha, Privada, Ducha higiênica e pia com espelho)", 350.00, 20),
    STANDARD_DUPLO(4, "1 x Queen Size e 2 x Solteiro",
            Arrays.asList("Sofá", "Poltrona", "Poltrona", "Frigobar", "TV Led 54 pols.", "Mesa de Escritório", "Cadeira de Escritório"),
            "Simple (Box com Ducha, Privada, Ducha higiênica e pia com espelho)", 450.00, 15),
    LUXO_SIMPLES(2, "1 x King Size",
            Arrays.asList("Sofá", "Poltrona", "Poltrona", "Frigobar", "TV Led 62 pols.", "Mesa de Escritório", "Cadeira de Escritório"),
            "Luxo (Box com Ducha, Privada, Ducha higiênica e pia dupla com espelho)", 550.00, 20),
    LUXO_DUPLO(4, "1 x King Size e 2 x Solteiro",
            Arrays.asList("Sofá", "Poltrona", "Poltrona", "Frigobar", "TV Led 62 pols.", "Mesa de Escritório", "Cadeira de Escritório"),
            "Luxo (Box com Ducha, Privada, Ducha higiênica e pia dupla com espelho)", 650.00, 15),
    PREMIUM_SIMPLES(2, "1 x King Size",
            Arrays.asList("Sofá", "Poltrona", "Poltrona", "Frigobar", "TV Led 62 pols.", "Mesa de Escritório", "Cadeira de Escritório"),
            "Premium (Box com Ducha, Privada, Ducha higiênica, pia dupla com espelho e Sauna)", 850.00, 10),
    PREMIUM_DUPLO(4, "2 x King Size",
            Arrays.asList("Sofá", "Poltrona", "Poltrona", "Frigobar", "TV Led 62 pols.", "Mesa de Escritório", "Cadeira de Escritório"),
            "Premium (Box com Ducha, Privada, Ducha higiênica, pia dupla com espelho e Sauna)", 950.00, 5);

    private final int capacidadePessoas;
    private final String qtdeCamas;
    private final List<String> moveis;
    private final String tipoBanheiro;
    private final double valorDiaria;
    private final int quantidadeQuartos;
}
