package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicos")
public class Servicos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_servico")
  private Long id;
  private String descricao;
  private Double valor;

  @ManyToMany(mappedBy = "servicos")
  @Setter(AccessLevel.NONE)
  private Set<Reserva> reservas = new HashSet<>();

}
