package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.LineItem;
import com.example.demo.model.Order;
import com.example.demo.model.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AgggrrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgggrrApplication.class, args);
	}

	@Bean
	public CommandLineRunner doIt(OrderRepository orders) {
		return args -> {

			Order o = new Order();
			o.addLineItem(new LineItem());
			orders.save(o);

		};
	}

}
