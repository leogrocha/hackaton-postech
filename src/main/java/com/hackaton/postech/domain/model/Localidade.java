package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.LocalidadeRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "localidade", cascade = CascadeType.ALL)
    private List<Amenidade> amenidades;

    public static Localidade of(LocalidadeRequestDTO request) {
        var localidade = new Localidade();
        copyProperties(request, localidade);

        Endereco endereco = Endereco.of(request.getEnderecoRequest());
        localidade.setEndereco(endereco);
        return localidade;
    }
}
