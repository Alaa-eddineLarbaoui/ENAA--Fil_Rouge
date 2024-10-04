package com.example.ENAA__Fil_Rouge.dto;

import com.example.ENAA__Fil_Rouge.models.Availability;
import com.example.ENAA__Fil_Rouge.models.HealthProfessional;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link Availability}
 */
@Value
public class AvailabilityDto implements Serializable {
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;
    HealthProfessional professional;
    boolean available = true;
}