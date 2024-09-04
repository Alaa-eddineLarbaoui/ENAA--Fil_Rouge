

package com.example.ENAA__Fil_Rouge.controllers;

import com.example.ENAA__Fil_Rouge.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

//    @Autowired
//    private NotificationService notificationService;
//
//    @GetMapping("/send")
//    public ResponseEntity<String> sendNotifications() {
//        notificationService.envoyerNotifications();
//        return ResponseEntity.ok("Notifications envoyées avec succès.");
//    }

}

