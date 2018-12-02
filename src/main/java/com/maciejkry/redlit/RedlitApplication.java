package com.maciejkry.redlit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RedlitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedlitApplication.class, args);
	}
}
