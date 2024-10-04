package com.example.docnet.repositories;

import com.example.docnet.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByDateSendBeforeAndIsSentFalse(LocalDateTime dateSend);
    List<Notification>findByPatientId(Long id);
}
