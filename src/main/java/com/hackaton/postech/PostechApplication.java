package com.hackaton.postech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hackaton.postech")
public class PostechApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostechApplication.class, args);
	}

}
