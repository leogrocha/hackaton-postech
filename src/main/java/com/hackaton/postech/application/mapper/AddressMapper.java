package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.AddressRequestDTO;
import com.hackaton.postech.domain.dto.response.AddressResponseDTO;
import com.hackaton.postech.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

//    @Mapping(target = "addressId", source = "address.addressId")
//    @Mapping(target = "street", source = "address.street")
//    @Mapping(target = "number", source = "address.number")
//    @Mapping(target = "neighborhood", source = "address.neighborhood")
//    @Mapping(target = "city", source = "address.city")
//    @Mapping(target = "state", source = "address.state")
//    @Mapping(target = "zipcode", source = "address.zipcode")
//    @Mapping(target = "complement", source = "address.complement")
//    AddressResponseDTO convertToAddressResponseDTO(Address address);
//
//    @Mapping(target = "street", source = "addressRequestDTO.street")
//    @Mapping(target = "number", source = "addressRequestDTO.number")
//    @Mapping(target = "neighborhood", source = "addressRequestDTO.neighborhood")
//    @Mapping(target = "city", source = "addressRequestDTO.city")
//    @Mapping(target = "state", source = "addressRequestDTO.state")
//    @Mapping(target = "zipcode", source = "addressRequestDTO.zipcode")
//    @Mapping(target = "complement", source = "addressRequestDTO.complement")
//    Address convertToAddress(AddressRequestDTO addressRequestDTO);
//
//
//    @Mapping(target = "addressId", source = "addressRequestDTO.addressRequestDTOId")
//    @Mapping(target = "street", source = "addressRequestDTO.street")
//    @Mapping(target = "number", source = "addressRequestDTO.number")
//    @Mapping(target = "neighborhood", source = "addressRequestDTO.neighborhood")
//    @Mapping(target = "city", source = "addressRequestDTO.city")
//    @Mapping(target = "state", source = "addressRequestDTO.state")
//    @Mapping(target = "zipcode", source = "addressRequestDTO.zipcode")
//    @Mapping(target = "complement", source = "addressRequestDTO.complement")
//    Address convertToAddressWithId(AddressRequestDTO addressRequestDTO, Long id);




}
