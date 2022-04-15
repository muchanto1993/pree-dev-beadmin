package com.pree.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BEAdminController {

    @GetMapping("/")
    public String helloBeAdmin() {
        return "BE Admin Service is Running";
    }

}
