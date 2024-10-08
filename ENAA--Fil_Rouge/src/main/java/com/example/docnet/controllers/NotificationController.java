

package com.example.docnet.controllers;

import com.example.docnet.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/send")
    public ResponseEntity<String> sendNotifications() {
        notificationService.envoyerNotifications();
        return ResponseEntity.ok("Notifications envoyées avec succès.");
    }

}
