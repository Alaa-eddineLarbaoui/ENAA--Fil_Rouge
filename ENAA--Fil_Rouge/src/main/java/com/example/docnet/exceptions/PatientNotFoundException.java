package com.example.docnet.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long patId) {
        super("Le patient avec l'ID " + patId + " n'a pas été trouvé.");
    }
}
