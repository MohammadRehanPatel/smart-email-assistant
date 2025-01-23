package com.email.writer.controller;

import com.email.writer.model.EmailRequest;
import com.email.writer.service.EmailGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmailGeneratorController {

    private EmailGeneratorService emailGeneratorService;

    public EmailGeneratorController(EmailGeneratorService emailGeneratorService) {
        this.emailGeneratorService = emailGeneratorService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
        return ResponseEntity.ok(
                emailGeneratorService
                        .generateEmailReplay(emailRequest));
    }


}
