package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
	
	@Autowired
	PlayService playService; 

	@Override
	public void run(ApplicationArguments args) throws Exception {
		playService.createVod();
		playService.publishVod();
		playService.deleteVod();
	}

}
