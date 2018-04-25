package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.LineItem;
import com.example.demo.model.Order;
import com.example.demo.model.OrderRepository;
import com.example.demo.model.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AgggrrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgggrrApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner doIt(OrderRepository orders, OrderService service) {
		return args -> {
			Order o1 = new Order("One");
			Order o2 = new Order("Two");
			Order o3 = new Order("Three");
			Order o4 = new Order("Four");
			Order o5 = new Order("Five");
			o1.addLineItem(new LineItem("Hey"));
			o1.addLineItem(new LineItem("Hey2"));
			orders.saveAll(Arrays.asList(o1, o2, o3, o4, o5));

			log.info("Allright");

			service.checkIt("One");

			o1.addLineItem(new LineItem("First"));
			log.info("Before save!");
			orders.save(o1);
			service.checkIt("One");

			LineItem item1 = new LineItem("Cool 1");
			LineItem item2 = new LineItem("Cool 2");
			LineItem item3 = new LineItem("Cool 3");

			o2.addLineItem(item1);
			o2.addLineItem(item2);
			o2.addLineItem(item3);

			orders.save(o2);
			service.checkIt("Two");
			service.rearrange();
			service.checkIt("Two");
			// service.delete("Two");

			// orders.delete(o2);
		};
	}

}
