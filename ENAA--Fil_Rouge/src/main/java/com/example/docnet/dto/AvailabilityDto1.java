package com.example.docnet.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link com.example.docnet.models.Availability}
 */
@Value
public class AvailabilityDto1 implements Serializable {
    LocalTime startTime;
    LocalTime endTime;
}