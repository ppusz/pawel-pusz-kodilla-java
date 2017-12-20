package com.kodilla.spring.web.web;

import com.kodilla.spring.web.web.SendSmsRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSmsController {

    @PostMapping("/api/sms")
    public void sendSms(@RequestBody SendSmsRequest sendSmsRequest) {
        System.out.println(sendSmsRequest.toString());
    }

    @GetMapping
    public void fo() {
        System.out.println("Hello world!");
    }



}