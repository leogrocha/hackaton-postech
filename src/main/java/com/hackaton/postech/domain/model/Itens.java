package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itens")
public class Itens {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_item")
  private Long id;
  private String descricao;
  private Double valor;

  @ManyToMany(mappedBy = "itens")
  @Setter(AccessLevel.NONE)
  private Set<Reserva> reservas = new HashSet<>();
}
