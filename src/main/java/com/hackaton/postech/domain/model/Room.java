package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.enums.TypeRoom;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_room")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"roomId"})
@ToString
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "building_id")
    private Building building;

    private String typeRoom;

    private int peopleCapacity;

    private String amountBeds;

    private String bathroomDescription;

    private double dailyValue;

    @ManyToMany
    @JoinTable(
        name = "tb_room_mobile",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "mobile_id")
    )
    private Set<Mobile> mobiles = new HashSet<>();

    @OneToOne(mappedBy = "room")
    private Reservation reservation;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "room_id")
//    private List<Mobile> mobiles;

//    @Override
//    public String toString() {
//        return "Quarto{" +
//                "id=" + id +
//                ", predio=" + predio +
//                ", tipoQuarto=" + tipoQuarto +
//                ", totalPessoas=" + capacidadePessoas +
//                ", totalCamas='" + qtdeCamas + '\'' +
//                ", valorDiaria=" + valorDiaria +
//                '}';
//    }

//    public Room(QuartoRequestDTO quartoRequestDTO) {
//        this.predio = PredioMapper.INSTANCE.convertToPredio(quartoRequestDTO.getPredio());
//        this.tipoQuarto = quartoRequestDTO.getTipoQuarto();
//        this.capacidadePessoas = this.tipoQuarto.getCapacidadePessoas();
//        this.qtdeCamas = this.tipoQuarto.getQtdeCamas();
//        this.valorDiaria = this.tipoQuarto.getValorDiaria();
//        this.moveis = MovelService.obterOuCriarMoveisPadrao(this.tipoQuarto.getMoveis());
//    }

}

