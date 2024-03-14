package com.hackaton.postech.domain.model;



import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import static org.springframework.beans.BeanUtils.copyProperties;

@Entity
@Table(name = "tb_address")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"addressId"})
@ToString
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String street;

    private String number;

    private String neighborhood;

    private String complement;

    private String zipcode;

    private String city;

    private String state;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Client client;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Locality locality;

    public static Address ofSave(AddressRequestDTO addressRequestDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressRequestDTO, address);
        return address;
    }


    public static Address ofUpdate(AddressRequestDTO addressRequestDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressRequestDTO, address);
        return address;
    }
}