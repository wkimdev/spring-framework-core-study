package com.example.order;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	private OrderRepository orderRepository; 
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public Order save(Order order) {
		order.setCreated(new Date());
		order.setOrderStatus(OrderStatus.DRAFT);
		return orderRepository.save(order);
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("======================");
		System.out.println("hello spring core project");
		System.out.println("======================");
	}
	
}
