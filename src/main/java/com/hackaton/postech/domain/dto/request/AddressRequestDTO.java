package com.hackaton.postech.domain.dto.request;


import com.hackaton.postech.domain.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class AddressRequestDTO {

    Long AddressId;

    @NotBlank(message = "Rua não pode ser nulo ou em branco")
    private String street;

    @NotBlank(message = "Número não pode ser nulo ou em branco")
    private String number;

    @NotBlank(message = "Bairro não pode ser nulo ou em branco")
    private String neighborhood;

    @NotBlank(message = "Cidade não pode ser nulo ou em branco")
    private String city;

    @NotBlank(message = "Estado não pode ser nulo ou em branco")
    private String state;

    @NotBlank(message = "CEP não pode ser nulo ou em branco")
    private String zipcode;

    private String complement;

    public static AddressRequestDTO of(Address address) {
        AddressRequestDTO addressRequestDTO = new AddressRequestDTO();
        BeanUtils.copyProperties(address, addressRequestDTO);
        return addressRequestDTO;

    }

}
