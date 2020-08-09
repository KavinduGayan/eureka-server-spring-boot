package com.bookstore.bookstorediscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookstoreDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreDiscoveryServiceApplication.class, args);
	}

}
