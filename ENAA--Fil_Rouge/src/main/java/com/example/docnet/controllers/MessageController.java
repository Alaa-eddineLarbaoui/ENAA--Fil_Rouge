package com.example.docnet.controllers;

import com.example.docnet.models.Notification;
import com.example.docnet.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notification/")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

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
