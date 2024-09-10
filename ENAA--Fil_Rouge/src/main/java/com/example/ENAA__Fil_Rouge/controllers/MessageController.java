package com.example.ENAA__Fil_Rouge.controllers;

import com.example.ENAA__Fil_Rouge.models.Notification;
import com.example.ENAA__Fil_Rouge.services.MessageService;
import com.example.ENAA__Fil_Rouge.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notification/")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * Envoie une notification manuelle à un patient.
     *
     * @param patientId ID du patient à qui envoyer la notification.
     * @param healthProfessionalId ID du professionnel de santé qui envoie la notification.
     * @param message Le message à envoyer.
     */
    @PostMapping("send")
    public void sendNotification(@RequestParam Long patientId,
                                 @RequestParam Long healthProfessionalId,
                                 @RequestParam String message) {
        messageService.envoyerNotificationManuelle(patientId, healthProfessionalId, message);
    }
    
    @GetMapping("getAll")
    public List<Notification> findAllnotifByID(Long id ){
        return messageService.findNotificationByPatientId(id);
    }
}
