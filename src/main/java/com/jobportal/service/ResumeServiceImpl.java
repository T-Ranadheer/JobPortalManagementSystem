package com.jobportal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Override
    public void uploadResume(MultipartFile file) {

        String uploadDir = "uploads/resume/";

        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {

            String fileName = System.currentTimeMillis()
                    + "_" + file.getOriginalFilename();

            file.transferTo(new File(uploadDir + fileName));

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}