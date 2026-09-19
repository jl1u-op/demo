package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Value("${APP_ENV:local}")
    private String appEnv;

    @GetMapping("/hello")
    public String hello() {
        return "Hello from DigitalOcean!";
    }

    @GetMapping("/info")
    public String info() {
        return "Environment: " + appEnv;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/message")
    public String getMessage() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
            "http://demo2:8080/internal/message",
            String.class
        );
    }
}