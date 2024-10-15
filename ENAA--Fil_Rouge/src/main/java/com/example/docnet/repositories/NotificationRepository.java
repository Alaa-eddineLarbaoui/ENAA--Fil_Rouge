package com.example.docnet.repositories;

import com.example.docnet.models.Notificatiion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notificatiion, Long> {
    List<Notificatiion> findByDateSendBeforeAndIsSentFalse(LocalDateTime dateSend);
    List<Notificatiion>findByPatientId(Long id);
}
