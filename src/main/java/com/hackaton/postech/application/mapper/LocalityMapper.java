package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.LocalityRequestDTO;
import com.hackaton.postech.domain.dto.response.LocalityResponseDTO;
import com.hackaton.postech.domain.model.Locality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface LocalityMapper {

//    @Mapping(target = "localityId", source = "locality.localityId")
//    @Mapping(target = "name", source = "locality.name")
//    @Mapping(target = "address", source = "locality.address")
//    LocalityResponseDTO convertToLocalityResponseDTO(Locality locality);
//
//    @Mapping(target = "name", source = "localityRequestDTO.name")
//    @Mapping(target = "address", source = "localityRequestDTO.address")
//    Locality convertToLocality(LocalityRequestDTO localityRequestDTO);
//
//    @Mapping(target = "localityId", source = "localityRequestDTO.localityId")
//    @Mapping(target = "name", source = "localityRequestDTO.name")
//    @Mapping(target = "address", source = "localityRequestDTO.address")
//    Locality convertToLocalityWithId(LocalityRequestDTO localityRequestDTO, Long id);
}
