package com.jobportal.service;

import com.jobportal.entity.Notification;
import com.jobportal.entity.User;

import java.util.List;

public interface NotificationService {

    Notification save(Notification notification);

    List<Notification> getNotifications(User user);

    Notification getNotification(Long id);

    void delete(Long id);

}