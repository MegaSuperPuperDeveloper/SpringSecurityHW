package com.example.springsecurityhw.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    @GetMapping("/user")
    public String user() {
        return "You're a user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "You're a admin";
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

}