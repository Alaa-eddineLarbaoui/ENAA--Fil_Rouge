package com.example.docnet.dto;

import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Notificatiion;
import com.example.docnet.models.Patient;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Notificatiion}
 */
@Value
public class NotificatiionDto implements Serializable {
    Long id;
    String message;
    LocalDateTime dateSend;
    boolean isSent;
    Patient patient;
    HealthProfessional healthProfessional;
}