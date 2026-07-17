package com.jobportal.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.nio.file.*;

@Controller
public class ResumeController {

    @GetMapping("/resume/download/{fileName}")
    public ResponseEntity<Resource> downloadResume(
            @PathVariable String fileName) throws Exception {

        Path path = Paths.get("uploads/resume/")
                .resolve(fileName);

        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()

                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileName + "\"")

                .body(resource);
    }

}