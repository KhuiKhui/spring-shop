package com.example.spring_shop.controllers.inter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface ICartController {
    @GetMapping("/cart")
    String getCartItems(Model model);

    @PostMapping("/cart")
    String checkout(Model model);
}
