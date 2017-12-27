package com.kodilla.spring.web.web;

import java.time.LocalDateTime;

public class HelloResponse {

    private String text;
    private LocalDateTime date;

    public HelloResponse(String text, LocalDateTime date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
