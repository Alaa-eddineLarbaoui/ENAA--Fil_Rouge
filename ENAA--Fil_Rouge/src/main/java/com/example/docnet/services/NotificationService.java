package com.example.docnet.services;

import com.example.docnet.models.Appointment;
import com.example.docnet.repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Scheduled(fixedDelay = 10000000)
    public void envoyerNotifications() {
        LocalDateTime maintenant = LocalDateTime.now();
        LocalDateTime dans48Heures = maintenant.plusHours(48);

        // Extraction de la date et de l'heure
        LocalDate date2 = maintenant.toLocalDate();
        LocalDate date1 = dans48Heures.toLocalDate();

        // Rechercher les rendez-vous dans les 48 prochaines heures et dont les notifications n'ont pas encore été envoyées

        List<Appointment> appointments = appointmentRepository
                .findByDateAndTimeBeforeAndNotificationEnvoyeeFalse(date1, date2);
        System.out.println(appointments.size());


        for (Appointment appointment : appointments) {
            String nomPatient = appointment.getPatient().getUsername();
            String nomProfessional = appointment.getProfessional().getUsername();
            envoyerEmail(appointment.getPatient().getEmail(), nomPatient, appointment.getTime(),appointment.getDate(), nomProfessional);
            appointment.setNotificationEnvoyee(true);
            appointmentRepository.save(appointment);
        }
    }


    private void envoyerEmail(String emailPatient, String nomPatient, LocalTime time, LocalDate date, String nomProfessional) {
        // Combine la date et l'heure en un seul LocalDateTime
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // Format de la date en anglais
        DateTimeFormatter formatterEnglish = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm", Locale.ENGLISH);
        String formattedDateEnglish = dateTime.format(formatterEnglish);

        // Format de la date en arabe
        DateTimeFormatter formatterArabic = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm", new Locale("ar"));
        String formattedDateArabic = dateTime.format(formatterArabic);

        // Message avec les deux versions
        String message = "Hello " + nomPatient + ",\n\n" +
                "This is a reminder for your appointment scheduled on " + formattedDateEnglish + ".\n" +
                "Your appointment is with Dr. " + nomProfessional + ".\n\n" +
                "مرحبا " + nomPatient + "،\n\n" +
                "هذه تذكرة بموعدك المحدد في " + formattedDateArabic + ".\n" +
                "موعدك مع الدكتور " + nomProfessional + ".\n\n" +
                "Thank you for your attention.\n" +
                "شكرا لاهتمامك.";

        // Configuration de l'email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("doctNet@outlook.com");
        mailMessage.setTo(emailPatient);
        mailMessage.setSubject("Appointment Reminder / تذكير بالموعد");
        mailMessage.setText(message);

        // Envoi de l'email
        mailSender.send(mailMessage);
    }
}

