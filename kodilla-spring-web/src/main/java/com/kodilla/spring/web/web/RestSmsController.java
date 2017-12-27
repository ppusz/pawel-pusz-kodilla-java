package com.kodilla.spring.web.web;

import com.kodilla.spring.web.web.SendSmsRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RestSmsController {

    @PostMapping("/api/sms")
    public void sendSms(@RequestBody SendSmsRequest sendSmsRequest) {
        System.out.println(sendSmsRequest.toString());
    }

    @GetMapping("/api/sms")
    public HelloResponse hello()
    {
        return new HelloResponse("Hello there!", LocalDateTime.now());
    }



}