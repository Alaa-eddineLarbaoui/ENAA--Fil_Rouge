package com.example.docnet.controllers;

import com.example.docnet.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Envoie des notifications aux patients.
     *
     * @return Un message de confirmation indiquant que les notifications ont été envoyées avec succès.
     */
    @GetMapping("/send")
    public ResponseEntity<String> sendNotifications() {
        notificationService.envoyerNotifications();
        return ResponseEntity.ok("Notifications envoyées avec succès.");
    }
}
