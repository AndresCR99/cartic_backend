package com.backend.carticback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarticBackApplication {

	public static void main(String[] args) {
		Config config = new Config();
		config.dbProperties();
		SpringApplication.run(CarticBackApplication.class, args);
	}

}
