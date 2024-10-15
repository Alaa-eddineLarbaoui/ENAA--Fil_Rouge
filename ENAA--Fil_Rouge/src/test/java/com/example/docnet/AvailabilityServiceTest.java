//package com.example.docnet;
//
//import com.example.docnet.dto.AvailabilityDto1;
//import com.example.docnet.exceptions.HealthProfessionalNotFoundException;
//import com.example.docnet.models.Appointment;
//import com.example.docnet.models.Availability;
//import com.example.docnet.models.HealthProfessional;
//import com.example.docnet.repositories.AppointmentRepository;
//import com.example.docnet.repositories.AvailabilityRepository;
//import com.example.docnet.repositories.HealthProfessionalRepository;
//import com.example.docnet.repositories.PatientRepository;
//import com.example.docnet.services.AvailabilityService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//class AvailabilityServiceTest {
//
//    @Mock
//    private AppointmentRepository appointmentRepository;
//
//    @Mock
//    private PatientRepository patientRepository;
//
//    @Mock
//    private HealthProfessionalRepository professionalRepository;
//
//    @Mock
//    private AvailabilityRepository availabilityRepository;
//
//    @InjectMocks
//    private AvailabilityService availabilityService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//
//    @Test
//    void testCreateAvailability() {
//        Availability availability = new Availability();
//        Long professionalId = 1L;
//        HealthProfessional healthProfessional = new HealthProfessional();
//        healthProfessional.setId(professionalId);
//
//        when(professionalRepository.findById(professionalId)).thenReturn(Optional.of(healthProfessional));
//        when(availabilityRepository.save(any(Availability.class))).thenReturn(availability);
//
//        Availability createdAvailability = availabilityService.createAvailability(availability, professionalId);
//
//        assertEquals(availability, createdAvailability);
//        verify(professionalRepository, times(1)).findById(professionalId);
//        verify(availabilityRepository, times(1)).save(availability);
//    }
//
//    @Test
//    void testCreateAvailability_ProfessionalNotFound() {
//        Availability availability = new Availability();
//        Long professionalId = 1L;
//
//        when(professionalRepository.findById(professionalId)).thenReturn(Optional.empty());
//
//        assertThrows(HealthProfessionalNotFoundException.class, () -> {
//            availabilityService.createAvailability(availability, professionalId);
//        });
//
//        verify(professionalRepository, times(1)).findById(professionalId);
//    }
//
//    @Test
//    void testDeleteAvailabilityTime() {
//        Long availabilityId = 1L;
//        doNothing().when(availabilityRepository).deleteById(availabilityId);
//
//        availabilityService.deleteAvaibilityTime(availabilityId);
//
//        verify(availabilityRepository, times(1)).deleteById(availabilityId);
//    }
//}
