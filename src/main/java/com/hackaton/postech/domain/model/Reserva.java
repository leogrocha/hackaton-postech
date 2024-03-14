package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_reserva")
  private Long id;

  @OneToOne
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  private LocalDateTime dataReserva;

  @OneToOne
  @JoinColumn(name = "id_quarto")
  private Quarto quarto;

  private Double valorTotal;

  private boolean confirmacaoEmail;

  @ManyToMany
  @JoinTable(
      name = "tb_reserva_itens",
      joinColumns = @JoinColumn(name = "id_reserva"),
      inverseJoinColumns = @JoinColumn(name = "id_item")
  )
  private Set<Itens> itens = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "tb_reserva_servicos",
      joinColumns = @JoinColumn(name = "id_reserva"),
      inverseJoinColumns = @JoinColumn(name = "id_servico")
  )
  private Set<Servicos> services = new HashSet<>();


}