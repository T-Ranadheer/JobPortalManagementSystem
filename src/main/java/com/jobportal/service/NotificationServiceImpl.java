package com.jobportal.service;

import com.jobportal.entity.Notification;
import com.jobportal.entity.User;
import com.jobportal.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotifications(User user) {
        return notificationRepository.findByUserOrderByCreatedAtDesc(user);
    }

    @Override
    public Notification getNotification(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}