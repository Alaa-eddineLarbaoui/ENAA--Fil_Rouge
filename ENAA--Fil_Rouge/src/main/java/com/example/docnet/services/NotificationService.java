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


    @Scheduled(fixedDelay = 1000000000)
    public void envoyerNotifications() {
        LocalDateTime maintenant = LocalDateTime.now();
        LocalDateTime dans48Heures = maintenant.plusHours(48);

        // Extracting the date and time
        LocalDate date2 = maintenant.toLocalDate();
        LocalDate date1 = dans48Heures.toLocalDate();

        // Search for appointments in the next 48 hours for which notifications have not yet been sent

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
        // Combine date and time into a single LocalDateTime
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // Date format in English
        DateTimeFormatter formatterEnglish = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm", Locale.ENGLISH);
        String formattedDateEnglish = dateTime.format(formatterEnglish);

        // Date format in Arabic
        DateTimeFormatter formatterArabic = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm", new Locale("ar"));
        String formattedDateArabic = dateTime.format(formatterArabic);

        // Message with both language versions
        String message = "Hello " + nomPatient + ",\n\n" +
                "This is a reminder for your appointment scheduled on " + formattedDateEnglish + ".\n" +
                "Your appointment is with Dr. " + nomProfessional + ".\n\n" +
                "مرحبا " + nomPatient + "،\n\n" +
                "هذه تذكرة بموعدك المحدد في " + formattedDateArabic + ".\n" +
                "موعدك مع الدكتور " + nomProfessional + ".\n\n" +
                "Thank you for your attention.\n" +
                "شكرا لاهتمامك.";

        // Email configuration
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("doctNet@outlook.com");
        mailMessage.setTo(emailPatient);
        mailMessage.setSubject("Appointment Reminder / تذكير بالموعد");
        mailMessage.setText(message);

        // Sending the email
        mailSender.send(mailMessage);
    }
}

