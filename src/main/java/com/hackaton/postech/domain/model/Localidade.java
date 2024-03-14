package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "localidades")
public class Localidade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "idLocalidade", cascade = CascadeType.ALL)
    private List<Amenidade> amenidades;

    @OneToMany(mappedBy = "idLocalidade", cascade = CascadeType.REFRESH)
    private List<Predio> predios;





    public Localidade(LocalidadeRequestDTO localidadeRequest) {
        this.nome = localidadeRequest.getNome();
    }
}
