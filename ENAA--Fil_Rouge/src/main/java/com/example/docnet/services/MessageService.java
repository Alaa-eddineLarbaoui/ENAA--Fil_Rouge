package com.example.docnet.services;

import com.example.docnet.exceptions.HealthProfessionalNotFoundException;
import com.example.docnet.exceptions.PatientNotFoundException;
import com.example.docnet.models.HealthProfessional;
import com.example.docnet.models.Notificatiion;
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

    private NotificationRepository notificationRepository;
    private JavaMailSender mailSender;
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;

    @Autowired
    private HealthProfessionalRepository healthProfessionalRepository;

    @Autowired
    public MessageService(NotificationRepository notificationRepository, JavaMailSender mailSender,
                          AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.notificationRepository = notificationRepository;
        this.mailSender = mailSender;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * Sends a manual notification email to a specific patient.
     * @param patientId The ID of the patient to receive the notification.
     * @param healthProfessionalId The ID of the health professional sending the notification.
     * @param message The content of the notification message.
     */
    public void envoyerNotificationManuelle(Long patientId, Long healthProfessionalId, String message) {

        // Retrieve patient by ID; throw exception if not found
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(patientId));

        // Retrieve health professional by ID; throw exception if not found
        HealthProfessional healthProfessional = healthProfessionalRepository.findById(healthProfessionalId)
                .orElseThrow(() -> new HealthProfessionalNotFoundException(healthProfessionalId));

        // Send email notification to the patient
        envoyerEmail(patient.getEmail(), message, healthProfessional.getUsername());

        // Create and save a new notification record
        Notificatiion notification = new Notificatiion();
        notification.setMessage(message);
        notification.setDateSend(LocalDateTime.now());
        notification.setSent(true);
        notification.setPatient(patient);
        notification.setHealthProfessional(healthProfessional);

        notificationRepository.save(notification);
    }

    /**
     * Sends an email to a specified patient email address with a custom message.
     * @param emailPatient The email address of the patient.
     * @param message The content of the email message.
     * @param nomProfessional The name of the health professional sending the message.
     */
    private void envoyerEmail(String emailPatient, String message, String nomProfessional) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("doctNet@outlook.com");
        mailMessage.setTo(emailPatient);
        mailMessage.setSubject("Notification de rendez-vous");
        mailMessage.setText("Hey I'm your doctor " + nomProfessional + ": " + message);

        // Send the email through JavaMailSender
        mailSender.send(mailMessage);
    }

    /**
     * Retrieves all notifications sent to a specific patient by their ID.
     * @param id The ID of the patient whose notifications are to be retrieved.
     * @return A list of notifications associated with the specified patient.
     */
    public List<Notificatiion> findNotificationByPatientId(Long id) {
        return notificationRepository.findByPatientId(id);
    }
}
