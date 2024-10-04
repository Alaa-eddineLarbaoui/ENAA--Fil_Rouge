package com.example.docnet.services;

import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Notification;
import com.example.docnet.models.Patient;
import com.example.docnet.repositories.AppointmentRepository;
import com.example.docnet.repositories.HealthProfessionalRepository;
import com.example.docnet.repositories.NotificationRepository;
import com.example.docnet.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageService {


    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HealthProfessionalRepository healthProfessionalRepository;

    public void envoyerNotificationManuelle(Long patientId, Long healthProfessionalId, String message) {

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        HealthProfessional healthProfessional = healthProfessionalRepository.findById(healthProfessionalId).orElseThrow();

        envoyerEmail(patient.getEmail(), message, healthProfessional.getUsername());

        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setDateSend(LocalDateTime.now());
        notification.setSent(true);
        notification.setPatient(patient);
        notification.setHealthProfessional(healthProfessional);

        notificationRepository.save(notification);
    }

    private void envoyerEmail(String emailPatient, String message, String nomProfessional) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("doctNet@outlook.com");
        mailMessage.setTo(emailPatient);
        mailMessage.setSubject("Notification de rendez-vous");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }



    public List<Notification> findNotificationByPatientId(Long id ){
        return notificationRepository.findByPatientId(id);
    }
}




