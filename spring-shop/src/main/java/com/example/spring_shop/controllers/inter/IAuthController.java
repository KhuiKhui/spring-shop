package com.example.spring_shop.controllers.inter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface IAuthController {
    @GetMapping("/login")
    String getLogin();

    @PostMapping("/login")
    String submitLogin();
}
