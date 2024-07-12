package com.example.spring_shop.messages;

import org.springframework.stereotype.Component;

@Component
public class Welcome {
    public void getMessage(){
        System.out.println("Welcome to Spring Shop!");
    }
}
