package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.MovelRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "moveis")
public class Movel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;
    public static Movel of(MovelRequestDTO request) {
        var movel = new Movel();
        movel.setDescricao(request.getDescricao());
        return movel;
    }

    public Movel (String descricao) {
        this.descricao = descricao;
    }

}
