package com.email.writer.controller;

import com.email.writer.entity.EmailTemplate;
import com.email.writer.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/template")
public class EmailTemplateController {

    @Autowired
    private EmailTemplateService emailTemplateService;

    @PostMapping()
    public ResponseEntity<EmailTemplate> createTemplate(@RequestBody EmailTemplate emailTemplate){
        return  new ResponseEntity<>(emailTemplateService.createTemplate(emailTemplate), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmailTemplate>> getAllTemplates(){
        return ResponseEntity.ok(emailTemplateService.getAllTemplates());
    }




}
