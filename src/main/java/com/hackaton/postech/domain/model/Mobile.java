package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_mobile")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"mobileId"})
@ToString
@Getter
@Setter
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mobileId;

    private String description;

    @ManyToMany(mappedBy = "mobiles")
    @Setter(AccessLevel.NONE)
    private Set<Room> rooms = new HashSet<>();

    public Mobile(String description) {
        this.description = description;
    }


}
