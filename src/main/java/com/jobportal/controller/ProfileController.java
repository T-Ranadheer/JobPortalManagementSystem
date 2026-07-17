package com.jobportal.controller;

import com.jobportal.entity.User;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {

        User user = userService.getUserByEmail(authentication.getName());

        model.addAttribute("user", user);

        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(

            @ModelAttribute User user,

            @RequestParam("resumeFile") MultipartFile resumeFile,

            @RequestParam("image") MultipartFile image

    ) throws IOException {

        User existing = userService.getUserById(user.getId());

        existing.setFullName(user.getFullName());
        existing.setPhone(user.getPhone());
        existing.setAddress(user.getAddress());
        existing.setEducation(user.getEducation());
        existing.setSkills(user.getSkills());
        existing.setExperience(user.getExperience());
        existing.setGithub(user.getGithub());
        existing.setLinkedin(user.getLinkedin());

        // Resume Upload
        if (!resumeFile.isEmpty()) {

            String fileName = UUID.randomUUID() + "_" + resumeFile.getOriginalFilename();

            File folder = new File("uploads/resumes");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            resumeFile.transferTo(new File(folder, fileName));

            existing.setResume(fileName);
        }

        // Profile Image Upload
        if (!image.isEmpty()) {

            String imageName = UUID.randomUUID() + "_" + image.getOriginalFilename();

            File folder = new File("uploads/profile");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            image.transferTo(new File(folder, imageName));

            existing.setProfileImage(imageName);
        }

        userService.updateUser(existing);

        return "redirect:/profile?success";
    }

}