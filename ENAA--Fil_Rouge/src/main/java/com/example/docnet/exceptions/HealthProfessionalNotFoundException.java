package com.example.docnet.exceptions;

public class HealthProfessionalNotFoundException extends RuntimeException {
    public HealthProfessionalNotFoundException(Long professionalId) {
        super("Le professionnel de santé avec l'ID " + professionalId + " n'a pas été trouvé.");
    }
}
