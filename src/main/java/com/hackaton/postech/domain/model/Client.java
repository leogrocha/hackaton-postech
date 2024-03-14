package com.hackaton.postech.domain.model;


import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
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
    @Column(unique = true)
    private String document;
    private String passport;
    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    private String phone;
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public static Client ofSave(ClientRequestDTO clientRequestDTO, AddressRequestDTO addressRequestDTO) {
        Client client = new Client();
        client.setAddress(Address.ofSave(addressRequestDTO));
        BeanUtils.copyProperties(clientRequestDTO, client);
        return client;
    }

    public static Client ofUpdate(ClientRequestDTO clientRequestDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientRequestDTO, client);
        return client;
    }



}
