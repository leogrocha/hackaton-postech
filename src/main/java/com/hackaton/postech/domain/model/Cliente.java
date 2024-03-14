package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String paisOrigem;
  private String cpf;
  private String passaporte;
  private String nome;
  @Column(columnDefinition = "DATE")
  private LocalDate dataNascimento;
  private String telefone;
  private String email;
  




}
