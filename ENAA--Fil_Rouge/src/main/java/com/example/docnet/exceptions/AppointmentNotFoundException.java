package com.example.docnet.exceptions;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(Long id) {
        super("Le rendez-vous avec l'ID " + id + " n'a pas été trouvé.");
    }
}
