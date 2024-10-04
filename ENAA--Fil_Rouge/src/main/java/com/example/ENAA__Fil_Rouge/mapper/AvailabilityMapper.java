package com.example.ENAA__Fil_Rouge.mapper;

import com.example.ENAA__Fil_Rouge.dto.AvailabilityDto;
import com.example.ENAA__Fil_Rouge.models.Availability;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface AvailabilityMapper {
    Availability toEntity(AvailabilityDto availabilityDto);

    AvailabilityDto toDto(Availability availability);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Availability partialUpdate(AvailabilityDto availabilityDto, @org.mapstruct.MappingTarget Availability availability);
}