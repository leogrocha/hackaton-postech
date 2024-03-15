package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.AmenidadeRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "amenidades")
public class Amenidade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "id_localidade")
    private Long idLocalidade;


    public Amenidade(AmenidadeRequestDTO amenidadeRequest) {
        this.descricao = amenidadeRequest.getDescricao();
    }
}
