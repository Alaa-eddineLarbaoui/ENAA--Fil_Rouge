package com.example.docnet.mapper;

import com.example.docnet.dto.AvailabilityDto1;
import com.example.docnet.models.Availability;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AvailabilityMapper1 {
    Availability toEntity(AvailabilityDto1 availabilityDto1);

    AvailabilityDto1 toDto(Availability availability);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Availability partialUpdate(AvailabilityDto1 availabilityDto1, @MappingTarget Availability availability);
}