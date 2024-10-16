package com.example.docnet.dto;

import com.example.docnet.models.HealthProfessional;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Value
public class AvailabilityDto implements Serializable {
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;
    HealthProfessional professional;
    boolean available = true;
}