package com.example.docnet.dto;

import com.example.docnet.enums.AppointmentReason;
import com.example.docnet.enums.AppointmentStatus;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Patient;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Value
public class AppointmentDto implements Serializable {
    LocalDate date;
    LocalTime time;
    AppointmentStatus status;
    AppointmentReason appointmentReason;
    String note;
    boolean notificationEnvoyee;
    Patient patient;
    HealthProfessional professional;
}