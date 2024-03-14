package com.hackaton.postech.application.mapper;

import com.hackaton.postech.domain.dto.request.MobileRequestDTO;
import com.hackaton.postech.domain.dto.response.MobileResponseDTO;
import com.hackaton.postech.domain.model.Mobile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MobileMapper {

//    @Mapping(target = "mobileId", source = "mobile.mobileId")
//    @Mapping(target = "description", source = "mobile.description")
//    MobileResponseDTO convertToMobileResponseDTO(Mobile mobile);
//
//    @Mapping(target = "description", source = "mobileRequestDTO.description")
//    Mobile convertToMobile(MobileRequestDTO mobileRequestDTO);
//
//
//    @Mapping(target = "mobileId", source = "mobileRequestDTO.mobileId")
//    @Mapping(target = "description", source = "mobileRequestDTO.description")
//    Mobile convertToMobileWithId(MobileRequestDTO mobileRequestDTO, Long id);
}
