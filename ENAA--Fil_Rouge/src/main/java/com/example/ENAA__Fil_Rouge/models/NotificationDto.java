package com.example.ENAA__Fil_Rouge.models;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Notification}
 */
@Value
public class NotificationDto implements Serializable {
    String message;
    LocalDateTime dateSend;
    boolean isSent;
    Patient patient;
    HealthProfessional healthProfessional;
}