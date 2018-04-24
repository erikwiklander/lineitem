package com.example.demo.model;

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

}
