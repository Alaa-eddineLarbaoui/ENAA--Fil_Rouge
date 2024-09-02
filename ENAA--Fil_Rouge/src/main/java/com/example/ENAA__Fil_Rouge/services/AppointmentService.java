package com.example.ENAA__Fil_Rouge.services;

import com.example.ENAA__Fil_Rouge.enums.AppointmentReason;
import com.example.ENAA__Fil_Rouge.enums.AppointmentStatus;
import com.example.ENAA__Fil_Rouge.models.Appointment;
import com.example.ENAA__Fil_Rouge.repositories.AppointmentRepository;

import org.aspectj.weaver.patterns.AndPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointRepository;

   public Appointment addAppointment (Appointment appointment){
       return appointRepository.save(appointment);
   }

    public List<Appointment> getAllAppointment(){
        return appointRepository.findAll();
    }


    public void delete(Long idAppoint ){
         appointRepository.deleteById(idAppoint);
    }


    public Appointment getAppointment (Long idAppoint ){
        return appointRepository.findById(idAppoint).get();
    }

    public Appointment updateAppointment(Appointment appointment ,Long id ){
        Appointment appointment1 = getAppointment(id);

        appointment1.setDate(appointment.getDate());
        appointment1.setTime(appointment.getTime());
        appointment1.setStatus(appointment.getStatus());
        appointment1.setAppointmentReason(appointment.getAppointmentReason());
        appointment1.setNote(appointment.getNote());

        return appointRepository.save(appointment1);

    }


}
