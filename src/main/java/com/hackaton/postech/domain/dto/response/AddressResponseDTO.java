package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDTO {

    private Long addressId;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;
    private String complement;

    public static AddressResponseDTO of(Address address) {
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        BeanUtils.copyProperties(address, addressResponseDTO);
        return addressResponseDTO;
    }



}