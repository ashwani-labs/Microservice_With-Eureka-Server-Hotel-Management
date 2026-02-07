package com.example.RatingPortion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class RatingPortionApplication {

	public static void main(String[] args) {

		SpringApplication.run(RatingPortionApplication.class, args);
	}

}
