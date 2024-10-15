//package com.example.docnet;
//
//import com.example.docnet.exceptions.HealthProfessionalNotFoundException;
//import com.example.docnet.models.HealthProfessional;
//import com.example.docnet.repositories.HealthProfessionalRepository;
//import com.example.docnet.services.HealthProfessionalService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//class HealthProfessionalServiceTest {
//
//    @Mock
//    private HealthProfessionalRepository healthProfessionalRepository;
//
//    @InjectMocks
//    private HealthProfessionalService healthProfessionalService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testRegisterHealthProfessional() {
//        HealthProfessional healthProfessional = new HealthProfessional();
//        when(healthProfessionalRepository.save(healthProfessional)).thenReturn(healthProfessional);
//
//        HealthProfessional savedHealthProfessional = healthProfessionalService.registerHealthProfessional(healthProfessional);
//
//        assertEquals(healthProfessional, savedHealthProfessional);
//        verify(healthProfessionalRepository, times(1)).save(healthProfessional);
//    }
//
//    @Test
//    void testGetAllHealthProfessionals() {
//        HealthProfessional healthProfessional1 = new HealthProfessional();
//        HealthProfessional healthProfessional2 = new HealthProfessional();
//        List<HealthProfessional> healthProfessionals = Arrays.asList(healthProfessional1, healthProfessional2);
//
//        when(healthProfessionalRepository.findAll()).thenReturn(healthProfessionals);
//
//        List<HealthProfessional> result = healthProfessionalService.getAllHealthProfessionals();
//
//        assertEquals(2, result.size());
//        assertEquals(healthProfessionals, result);
//        verify(healthProfessionalRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testShowHealthProfessionalById() {
//        Long professionalId = 1L;
//        HealthProfessional healthProfessional = new HealthProfessional();
//        when(healthProfessionalRepository.findById(professionalId)).thenReturn(Optional.of(healthProfessional));
//
//        HealthProfessional result = healthProfessionalService.showHealthProfessionalById(professionalId);
//
//        assertEquals(healthProfessional, result);
//        verify(healthProfessionalRepository, times(1)).findById(professionalId);
//    }
//
//    @Test
//    void testShowHealthProfessionalById_NotFound() {
//        Long professionalId = 1L;
//        when(healthProfessionalRepository.findById(professionalId)).thenReturn(Optional.empty());
//
//        assertThrows(HealthProfessionalNotFoundException.class, () -> {
//            healthProfessionalService.showHealthProfessionalById(professionalId);
//        });
//
//        verify(healthProfessionalRepository, times(1)).findById(professionalId);
//    }
//}
