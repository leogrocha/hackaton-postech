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
  @Column(name = "id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  private LocalDateTime dataReserva;

  @OneToOne
  @JoinColumn(name = "quarto_id")
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
  private Set<Servicos> servicos = new HashSet<>();


}
