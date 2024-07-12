package com.example.spring_shop;

import com.example.spring_shop.messages.Welcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShopApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringShopApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);

		log.info("Application is updated!!!!!");

		Welcome	welcome = new Welcome();
		welcome.getMessage();
	}

}
