package com.example.docnet.mapper;

import com.example.docnet.dto.AvailabilityDto;
import com.example.docnet.models.Availability;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface AvailabilityMapper {
    Availability toEntity(AvailabilityDto availabilityDto);


    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Availability partialUpdate(AvailabilityDto availabilityDto, @org.mapstruct.MappingTarget Availability availability);
}