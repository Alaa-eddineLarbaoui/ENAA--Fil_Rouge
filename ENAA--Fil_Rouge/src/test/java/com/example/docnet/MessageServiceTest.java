//package com.example.docnet;
//
//import com.example.docnet.models.HealthProfessional;
//import com.example.docnet.models.Notificatiion;
//import com.example.docnet.models.Patient;
//import com.example.docnet.repositories.NotificationRepository;
//import com.example.docnet.repositories.AppointmentRepository;
//import com.example.docnet.repositories.PatientRepository;
//import com.example.docnet.repositories.HealthProfessionalRepository;
//import com.example.docnet.services.MessageService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import java.time.LocalDateTime;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//class MessageServiceTest {
//
//    @Mock
//    private NotificationRepository notificationRepository;
//
//    @Mock
//    private JavaMailSender mailSender;
//
//    @Mock
//    private AppointmentRepository appointmentRepository;
//
//    @Mock
//    private PatientRepository patientRepository;
//
//    @Mock
//    private HealthProfessionalRepository healthProfessionalRepository;
//
//    @InjectMocks
//    private MessageService messageService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testEnvoyerNotificationManuelle() {
//        Long patientId = 1L;
//        Long healthProfessionalId = 2L;
//        String message = "Your appointment is confirmed";
//
//        Patient patient = new Patient();
//        patient.setEmail("patient@example.com");
//
//        HealthProfessional healthProfessional = new HealthProfessional();
//        healthProfessional.setUsername("Dr. Smith");
//
//        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
//        when(healthProfessionalRepository.findById(healthProfessionalId)).thenReturn(Optional.of(healthProfessional));
//
//        messageService.envoyerNotificationManuelle(patientId, healthProfessionalId, message);
//
//         verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
//
//        // Vérifier que la notification a été enregistrée
//        Notificatiion notification = new Notificatiion();
//        notification.setMessage(message);
//        notification.setDateSend(LocalDateTime.now());
//        notification.setSent(true);
//        notification.setPatient(patient);
//        notification.setHealthProfessional(healthProfessional);
//
//        verify(notificationRepository, times(1)).save(any(Notificatiion.class));
//    }
//
//    @Test
//    void testEnvoyerNotificationManuelle_PatientNotFound() {
//        Long patientId = 1L;
//        Long healthProfessionalId = 2L;
//        String message = "Your appointment is confirmed";
//
//        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());
//
//        assertThrows(NoSuchElementException.class, () -> {
//            messageService.envoyerNotificationManuelle(patientId, healthProfessionalId, message);
//        });
//    }
//
//    @Test
//    void testEnvoyerNotificationManuelle_HealthProfessionalNotFound() {
//        Long patientId = 1L;
//        Long healthProfessionalId = 2L;
//        String message = "Your appointment is confirmed";
//
//        Patient patient = new Patient();
//        patient.setEmail("patient@example.com");
//
//        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
//        when(healthProfessionalRepository.findById(healthProfessionalId)).thenReturn(Optional.empty());
//
//
//         assertThrows(NoSuchElementException.class, () -> {
//            messageService.envoyerNotificationManuelle(patientId, healthProfessionalId, message);
//        });
//    }
//}
