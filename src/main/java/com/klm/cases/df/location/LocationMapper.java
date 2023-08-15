package com.klm.cases.df.location;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {

    LocationDTO toDTO(Location location);

    List<LocationDTO> toDTOs(List<Location> location);

    Location fromDTO(LocationDTO locationDTO);

    List<Location> fromDTOs(List<LocationDTO> locationDTOs);

}
