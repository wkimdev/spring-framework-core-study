package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SimplePlayService implements PlayService {
	
	//@PerfLogging
	@Override
	public void createVod() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("createVod start!! ");
	}

	//@PerfLogging
	@Override
	public void publishVod() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("publishVod start!! ");
	}

	@Override
	public void deleteVod() {
		System.out.println("deleteVod start!! ");
	}
	
	
}
