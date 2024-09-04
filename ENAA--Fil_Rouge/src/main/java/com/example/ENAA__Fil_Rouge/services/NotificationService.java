package com.example.ENAA__Fil_Rouge.services;

import com.example.ENAA__Fil_Rouge.models.Appointment;
import com.example.ENAA__Fil_Rouge.repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Scheduled(fixedRate = 3600000)
    public void envoyerNotifications() {
        LocalDateTime maintenant = LocalDateTime.now();

        LocalDateTime dans24Heures = maintenant.plusHours(24);

        List<Appointment> appointments = appointmentRepository
                .findByDateTimeBeforeAndNotificationEnvoyeeFalse(dans24Heures);


        for (Appointment appointment : appointments) {
            String nomPatient = appointment.getPatient().getUsername();
            String nomProfessional = appointment.getProfessional().getUsername();
            envoyerEmail(appointment.getPatient().getEmail(), nomPatient, appointment.getDateTime(), nomProfessional);
            appointment.setNotificationEnvoyee(true);
            appointmentRepository.save(appointment);
        }
    }


    private void envoyerEmail(String emailPatient, String nomPatient, LocalDateTime dateTime, String nomProfessional) {
        String message = "Bonjour " + nomPatient + ",\n\n" +
                "Ceci est un rappel pour votre rendez-vous prévu le " + dateTime + ".\n" +
                "Votre rendez-vous est avec le Dr. " + nomProfessional + ".\n\n" +
                "Merci de votre attention.";



        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("doctNet@outlook.com");
        mailMessage.setTo(emailPatient);
        mailMessage.setSubject("Rappel de votre rendez-vous");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }

}

