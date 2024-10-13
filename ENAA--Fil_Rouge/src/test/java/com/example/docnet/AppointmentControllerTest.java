//package com.example.docnet;
//
//import com.example.docnet.controllers.AppointmentController;
//import com.example.docnet.models.Appointment;
//import com.example.docnet.services.AppointmentService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//class AppointmentControllerTest {
//
//    @Mock
//    private AppointmentService appointmentService;
//
//    @InjectMocks
//    private AppointmentController appointmentController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//
//    @Test
//    void testGetAppointmentById() {
//        Appointment appointment = new Appointment();
//        when(appointmentService.getAppointment(1L)).thenReturn(appointment);
//
//        Appointment result = appointmentController.getAppointmentById(1L);
//
//        assertEquals(appointment, result);
//        verify(appointmentService, times(1)).getAppointment(1L);
//    }
//
//    @Test
//    void testDeleteAppointment() {
//        doNothing().when(appointmentService).delete(1L);
//
//        appointmentController.deleteAppointment(1L);
//
//        verify(appointmentService, times(1)).delete(1L);
//    }
//
//    @Test
//    void testUpdateAppointment() {
//        Appointment appointment = new Appointment();
//        when(appointmentService.updateAppointment(any(Appointment.class), eq(1L))).thenReturn(appointment);
//
//        Appointment result = appointmentController.updateAppointment(1L, appointment);
//
//        assertEquals(appointment, result);
//        verify(appointmentService, times(1)).updateAppointment(appointment, 1L);
//    }
//
//    @Test
//    void testAddAppointment() {
//        Appointment appointment = new Appointment();
//        when(appointmentService.addAppointment(any(Appointment.class), eq(1L), eq(2L))).thenReturn(appointment);
//
//        Appointment result = appointmentController.addAppointment(appointment, 1L, 2L);
//
//        assertEquals(appointment, result);
//        verify(appointmentService, times(1)).addAppointment(appointment, 1L, 2L);
//    }
//
//    @Test
//    void testGetByDoctorId() {
//        List<Appointment> appointments = Arrays.asList(new Appointment(), new Appointment());
//        when(appointmentService.getAllByIdDoctor(1L)).thenReturn(appointments);
//
//        List<Appointment> result = appointmentController.getByDoctorId(1L);
//
//        assertEquals(appointments, result);
//        verify(appointmentService, times(1)).getAllByIdDoctor(1L);
//    }
//
//    @Test
//    void testGetByPatientId() {
//        List<Appointment> appointments = Arrays.asList(new Appointment(), new Appointment());
//        when(appointmentService.getAllByIdPatient(1L)).thenReturn(appointments);
//
//        List<Appointment> result = appointmentController.getByPatientId(1L);
//
//        assertEquals(appointments, result);
//        verify(appointmentService, times(1)).getAllByIdPatient(1L);
//    }
//}
