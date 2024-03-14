package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_itens")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"itemId"})
@ToString
@Getter
@Setter
public class Itens {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long itemId;
  private String description;
  private Double itemValue;

  @ManyToMany(mappedBy = "itens")
  @Setter(AccessLevel.NONE)
  private Set<Reservation> reservations = new HashSet<>();
}
