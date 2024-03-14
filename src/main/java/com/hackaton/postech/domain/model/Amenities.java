package com.hackaton.postech.domain.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_amenities")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"amenitiesId"})
@ToString
@Getter
@Setter
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenitiesId;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "locality_id")
    private Locality locality;

}
