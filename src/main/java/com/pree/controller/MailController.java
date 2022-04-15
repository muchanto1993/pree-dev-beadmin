package com.pree.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pree.format.mail.MailBodyFormat;
import com.pree.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MailController {

    // Creating Object of ObjectMapper define in Jakson Api
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    public MailBodyFormat sendMail(HttpServletRequest request, @RequestBody MailBodyFormat bodyFormat)
            throws JsonProcessingException {
        log.info("Request Client : " + request.getRemoteAddr());

        log.info("Request Message : " + objectMapper.writeValueAsString(bodyFormat));

        mailService.sendMail(bodyFormat.getData());

        MailBodyFormat responseMailBodyFormat = new MailBodyFormat();
        responseMailBodyFormat.setData(bodyFormat.getData());
        responseMailBodyFormat.setLogtime(new Date().toString());
        responseMailBodyFormat.setErrorcode("");
        responseMailBodyFormat.setErrordescription("");
        responseMailBodyFormat.setIssuccess(true);
        responseMailBodyFormat.setApikey(bodyFormat.getApikey());
        responseMailBodyFormat.setMessageguid(bodyFormat.getMessageguid());

        log.info("Response Message : " + objectMapper.writeValueAsString(responseMailBodyFormat));

        return responseMailBodyFormat;
    }

}
