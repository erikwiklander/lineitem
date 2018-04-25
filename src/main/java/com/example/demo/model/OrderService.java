package com.example.demo.model;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

	private final OrderRepository orders;

	@Transactional
	public void checkIt(String n) {
		log.info("Aw {} ", orders.findOne(QOrder.order.name.eq(n)).get().getItems());
	}

	@Transactional
	public void delete(String name) {
		Optional<Order> order = orders.findOne(QOrder.order.name.eq(name));
		if (order.isPresent()) {
			orders.delete(order.get());
		}
	}

	@Transactional
	public void rearrange() {
		Optional<Order> order = orders.findOne(QOrder.order.name.eq("Two"));
		if (order.isPresent()) {
			List<LineItem> items = order.get().getItems();
			items.get(0).setIndex(1);
			items.get(1).setIndex(0);
			orders.save(order.get());
		}

	}
}
