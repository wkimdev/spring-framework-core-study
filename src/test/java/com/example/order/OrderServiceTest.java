package com.example.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OrderServiceTest {
		
	@Mock
	OrderRepository orderRepository;
	
	@Test
	public void save() {
		Order order = new Order();
		
		/*
		 * OrderService는 null을 리턴하는 orderrepository에 의존적이기 때문에 
		 * 	 가짜 객체를 만들어 null를 리턴하지 않는 테스트를 한다(모킹) 
		 */
		// OrderRepository orderRepository = new OrderRepository(); // 기존 코드
		when(orderRepository.save(order)).thenReturn(order);	// 동일한 인스턴스를 응답한다. 
		OrderService orderService = new OrderService(orderRepository);
		
		Order result = orderService.save(order);
		
		// null이 나오지 않길 바랄 경우 
		assertThat(order.getCreated()).isNotNull();
		assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.DRAFT);
		assertThat(result).isNotNull();
		
	}

}
