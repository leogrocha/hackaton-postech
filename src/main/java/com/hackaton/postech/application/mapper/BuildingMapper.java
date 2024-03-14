package com.hackaton.postech.application.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BuildingMapper {

//    BuildingMapper INSTANCE = Mappers.getMapper(BuildingMapper.class);
//
//    @Mapping(target = "buildingId", source = "building.buildingId")
//    @Mapping(target = "name", source = "building.nome")
//    @Mapping(target = "locality", source = "building.locality")
//    BuildingResponseDTO convertToBuildingResponseDTO(Building building);
//
//    @Mapping(target = "name", source = "buildingRequestDTO.name")
//    @Mapping(target = "locality", source = "buildingRequestDTO.locality")
//    Building convertToBuilding(BuildingRequestDTO buildingRequestDTO);
//
//    @Mapping(target = "buildingId", source = "buildingRequestDTO.buildingId")
//    @Mapping(target = "name", source = "buildingRequestDTO.name")
//    @Mapping(target = "locality", source = "buildingRequestDTO.locality")
//    Building convertToBuildingWithId(BuildingRequestDTO buildingRequestDTO, Long id);
}
