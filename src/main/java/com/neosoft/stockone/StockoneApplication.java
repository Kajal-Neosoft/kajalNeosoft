package com.neosoft.stockone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StockoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockoneApplication.class, args);
	}

}
