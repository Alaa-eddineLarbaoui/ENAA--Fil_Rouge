package com.example.docnet.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link com.example.docnet.models.Availability}
 */
@Value
@AllArgsConstructor
@Getter
@Setter
public class AvailabilityDto1 implements Serializable {

    Long id;
    LocalTime startTime;

}