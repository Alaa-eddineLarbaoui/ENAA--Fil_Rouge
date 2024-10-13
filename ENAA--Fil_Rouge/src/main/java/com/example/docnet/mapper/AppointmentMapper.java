package com.example.docnet.mapper;

import com.example.docnet.models.Appointment;
import com.example.docnet.dto.AppointmentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper {
    Appointment toEntity(AppointmentDto appointmentDto);

    AppointmentDto toDto(Appointment appointment);

    List<AppointmentDto> toDtos(List<Appointment> appointments);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Appointment partialUpdate(AppointmentDto appointmentDto, @MappingTarget Appointment appointment);
}