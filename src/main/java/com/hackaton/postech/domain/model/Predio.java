package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "predios")
public class Predio {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    public static Predio of(PredioRequestDTO request, Localidade localidade) {
        var predio = new Predio();
        predio.setNome(request.getNome());
        predio.setLocalidade(localidade);
        return predio;
    }

}
