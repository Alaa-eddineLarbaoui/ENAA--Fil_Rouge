package com.example.docnet.dto;

import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Patient;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;


@Value
public class NotificationDto implements Serializable {
    String message;
    LocalDateTime dateSend;
    boolean isSent;
    Patient patient;
    HealthProfessional healthProfessional;
}