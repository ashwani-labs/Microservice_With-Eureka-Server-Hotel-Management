package com.example.apigateway.CloudGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayApplication {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("USER-SERVICE", r -> r.path("/user/**")
						.uri("lb://USER-SERVICE"))
				.route("HOTEL-SERVICE", r -> r.path("/hotel/**,/staff/*")
						.uri("lb://HOTEL-SERVICE"))
				.route("RATING-SERVICE", r -> r.path("/rating/**")
						.filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
						.uri("lb://RATING-SERVICE"))

				.build();
	}

	public static void main(String[] args) {

		SpringApplication.run(CloudGatewayApplication.class, args);
	}

}
