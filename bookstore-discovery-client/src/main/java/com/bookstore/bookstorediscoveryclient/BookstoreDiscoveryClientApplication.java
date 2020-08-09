package com.bookstore.bookstorediscoveryclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class BookstoreDiscoveryClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreDiscoveryClientApplication.class, args);
    }
	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
class ServiceInstanceRestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/books")
    public ResponseEntity<List> getBooks() {
        return new ResponseEntity<>(restTemplate.getForObject("http://PRICE-SERVICE/prices", List.class), HttpStatus.ACCEPTED);
    }
}

