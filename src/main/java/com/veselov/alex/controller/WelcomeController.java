package com.veselov.alex.controller;

import com.veselov.alex.serivec.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private HiService service;

    @GetMapping("/hi")
    public String hi() {
        return this.service.getHiMsg();
    }
}
