package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AgggrrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgggrrApplication.class, args);
	}

	@Bean
	public CommandLineRunner doIt() {
		return args -> log.info("No way!");
	}

}
