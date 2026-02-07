package com.example.HotelPortion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelPortionApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelPortionApplication.class, args);
	}

}
