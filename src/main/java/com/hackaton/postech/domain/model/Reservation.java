package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_reservation")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"reservationId"})
@ToString
@Getter
@Setter
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long reservationId;

  @OneToOne
  @JoinColumn(name = "client_id")
  private Client client;
  private LocalDateTime reservationAt;
  @OneToOne
  @JoinColumn(name = "room_id")
  private Room room;
  private BigDecimal valueTotal;
  private boolean sendEmailConfirmation;
  @ManyToMany
  @JoinTable(
      name = "tb_reservation_itens",
      joinColumns = @JoinColumn(name = "reservation_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id")
  )
  private Set<Itens> itens = new HashSet<>();
  @ManyToMany
  @JoinTable(
      name = "tb_reservation_services",
      joinColumns = @JoinColumn(name = "reservation_id"),
      inverseJoinColumns = @JoinColumn(name = "service_id")
  )
  private Set<Services> services = new HashSet<>();


}
