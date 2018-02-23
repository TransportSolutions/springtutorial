package com.springtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springtutorial.backend.persistence.repositories")
public class SpringTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTutorialApplication.class, args);
	}
}
