package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_services")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"serviceId"})
@ToString
@Getter
@Setter
public class Services {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long serviceId;
  private String description;
  private Double serviceValue;

  @ManyToMany(mappedBy = "services")
  @Setter(AccessLevel.NONE)
  private Set<Reservation> reservations = new HashSet<>();
}
