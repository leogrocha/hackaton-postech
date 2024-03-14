package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.PredioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name = "id_localidade")
    private Long idLocalidade;

    @OneToMany(mappedBy = "idPredio", cascade = CascadeType.ALL)
    private List<Quarto> quartos;


    public Predio(PredioRequestDTO predioRequest) {
        this.nome = predioRequest.getNome();
    }
}
