package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "amenidades")
public class Amenidade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    public static Amenidade of(AmenidadeRequestDTO request, Localidade localidade) {
        var amenidade = new Amenidade();
        amenidade.setDescricao(request.getDescricao());
        amenidade.setLocalidade(localidade);
        return amenidade;
    }
}
