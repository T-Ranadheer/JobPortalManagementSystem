package com.jobportal.controller;

import com.jobportal.entity.User;
import com.jobportal.service.NotificationService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @GetMapping("/notifications")
    public String notifications(Model model) {

        User user = userService.getUserById(1L);

        model.addAttribute("notifications",
                notificationService.getNotifications(user));

        return "notifications";
    }

    @GetMapping("/notification/delete/{id}")
    public String deleteNotification(@PathVariable Long id) {

        notificationService.delete(id);

        return "redirect:/notifications";
    }

}