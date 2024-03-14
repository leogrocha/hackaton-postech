package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.AmenitiesRequestDTO;
import com.hackaton.postech.domain.dto.response.AmenitiesResponseDTO;
import com.hackaton.postech.domain.model.Amenities;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AmenitiesMapper {

//    @Mapping(target = "amenitiesId", source = "amenities.amenitiesId")
//    @Mapping(target = "description", source = "amenities.description")
//    @Mapping(target = "locality", source = "amenities.locality")
//    AmenitiesResponseDTO convertToAmenitiesResponseDTO(Amenities amenities);
//
//    @Mapping(target = "description", source = "amenitiesRequestDTO.description")
//    @Mapping(target = "locality", source = "amenitiesRequestDTO.locality")
//    Amenities convertToAmenities(AmenitiesRequestDTO amenitiesRequestDTO);
//
//
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "description", source = "amenitiesRequestDTO.description")
//    @Mapping(target = "locality", source = "amenitiesRequestDTO.locality")
//    Amenities convertToAmenitiesWithId(AmenitiesRequestDTO amenitiesRequestDTO, Long id);
}
