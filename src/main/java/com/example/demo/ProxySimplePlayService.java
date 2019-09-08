package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
 * 1. 중복코드 생김
 * 2. 모든 클래스 delecation 써야 하고
 * 3. 다른 enrollment 서비스 같은 데에도 적용하면 모든 클래스에 대해 proxy class를 만들어야 한다. 
 * 
 *  ==> 이걸 줄일 수 있는 방법.. 
 * 		- 동적(run time)으로 프록시 객체를 만드는 방법이 있다.  -> 이게 스프링 aop  
 */
//@Primary
//@Service
public class ProxySimplePlayService implements PlayService {
	
	@Autowired
	SimplePlayService simplePlayService;

	@Override
	public void createVod() {
		// 로그 찍어줌 
		long begin = System.currentTimeMillis();
		// 기능 위힘 
		simplePlayService.createVod();
		System.out.print("this is proxy service.. ");
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Override
	public void publishVod() {
		// 로깅 
		long begin = System.currentTimeMillis();
		// 기능 위임 
		simplePlayService.publishVod();
		System.out.print("this is proxy service.. ");
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Override
	public void deleteVod() {
		// do nothing...
		// 기능 위임만
		System.out.print("this is proxy service.. ");
		simplePlayService.deleteVod();
	}

}
