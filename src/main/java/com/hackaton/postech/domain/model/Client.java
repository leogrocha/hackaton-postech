package com.hackaton.postech.domain.model;

import com.hackaton.postech.domain.dto.request.ClientRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

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
    private String passport;
    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
//    private Address address;
    private String phone;
    private String email;


}
