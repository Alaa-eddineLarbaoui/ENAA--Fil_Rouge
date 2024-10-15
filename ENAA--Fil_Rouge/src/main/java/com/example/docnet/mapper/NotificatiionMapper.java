package com.example.docnet.mapper;

import com.example.docnet.models.Notificatiion;
import com.example.docnet.dto.NotificatiionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificatiionMapper {
    Notificatiion toEntity(NotificatiionDto notificatiionDto);

    NotificatiionDto toDto(Notificatiion notificatiion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Notificatiion partialUpdate(NotificatiionDto notificatiionDto, @MappingTarget Notificatiion notificatiion);
}