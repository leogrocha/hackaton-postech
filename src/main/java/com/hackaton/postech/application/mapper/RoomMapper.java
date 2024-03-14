package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.RoomRequestDTO;
import com.hackaton.postech.domain.dto.response.RoomResponseDTO;
import com.hackaton.postech.domain.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface RoomMapper {

//    @Mapping(target = "roomId", source = "room.roomId")
//    @Mapping(target = "building", source = "room.building")
//    @Mapping(target = "typeRoom", source = "room.typeRoom")
//    @Mapping(target = "peopleCapacity", source = "room.peopleCapacity")
//    @Mapping(target = "amountBeds", source = "room.amountBeds")
//    @Mapping(target = "dailyValue", source = "room.dailyValue")
//    @Mapping(target = "mobiles", source = "room.mobiles")
//    RoomResponseDTO convertToRoomResponseDTO(Room room);
//
//    Room convertToRoom(RoomRequestDTO roomRequestDTO);
//
//
//    @Mapping(target = "roomId", source = "room.roomId")
//    @Mapping(target = "building", source = "room.building")
//    @Mapping(target = "typeRoom", source = "room.typeRoom")
//    @Mapping(target = "peopleCapacity", source = "room.peopleCapacity")
//    @Mapping(target = "amountBeds", source = "room.amountBeds")
//    @Mapping(target = "dailyValue", source = "room.dailyValue")
//    @Mapping(target = "mobiles", source = "room.mobiles")
//    Room convertToRoomWithId(RoomRequestDTO roomRequestDTO, Long id);
}
