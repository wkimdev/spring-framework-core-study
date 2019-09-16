package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WkimdevPracticePrj02Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WkimdevPracticePrj02Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
		SpringApplication.run(WkimdevPracticePrj02Application.class, args);
	}

}
