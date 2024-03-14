package com.hackaton.postech.domain.dto.response;

import com.hackaton.postech.domain.model.Client;
import com.hackaton.postech.domain.model.Locality;
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
public class LocalityResponseDTO {

    private Long localityId;
    private String name;
    private AddressResponseDTO address;

    public static LocalityResponseDTO of(Locality locality) {
        var localityResponseDTO = new LocalityResponseDTO();

        BeanUtils.copyProperties(locality, localityResponseDTO);
        return localityResponseDTO;
    }




}
