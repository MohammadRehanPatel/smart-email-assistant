package com.email.writer.service;

import com.email.writer.entity.EmailTemplate;
import com.email.writer.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailTemplateService {

    @Autowired
    private EmailTemplateRepository templateRepository;

    public EmailTemplate createTemplate(EmailTemplate emailTemplate){
        return templateRepository.save(emailTemplate);
    }

    public List<EmailTemplate> getAllTemplates(){
        return templateRepository.findAll();
    }

    public void deleteTemplate(int id){
        templateRepository.deleteById(id);
    }

    public EmailTemplate updateTemplate(int id,EmailTemplate emailTemplate){
        EmailTemplate newTemplate = templateRepository.findById(id).orElseThrow();

        newTemplate.setSubject(emailTemplate.getSubject());
        newTemplate.setBody(emailTemplate.getBody());
        newTemplate.setAttachment(emailTemplate.getAttachment());

        return newTemplate;


    }


}
