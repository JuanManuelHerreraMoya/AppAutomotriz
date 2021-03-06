package com.nexos.app;

import com.nexos.app.controller.InventarioAPIController;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = {"com.nexos.app.controller",
		"com.nexos.app.service"})
@EnableJpaRepositories("com.nexos.app.repository")
@EntityScan("com.nexos.app.model")
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
