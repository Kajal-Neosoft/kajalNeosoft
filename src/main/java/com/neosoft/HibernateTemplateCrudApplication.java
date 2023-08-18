package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class HibernateTemplateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateTemplateCrudApplication.class, args);
	}

}
