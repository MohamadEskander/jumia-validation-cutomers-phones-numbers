package com.example.jumiatask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class JumiaTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(JumiaTaskApplication.class, args);
	}
}