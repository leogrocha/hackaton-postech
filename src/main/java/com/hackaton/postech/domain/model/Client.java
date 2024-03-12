package com.hackaton.postech.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"clientId"})
@ToString
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String countryOfOrigin;
    private String document;
    private String passaport;
    private String name;
    private LocalDate birthDate;
//    private Address address;
    private String phone;
    private String email;
}
