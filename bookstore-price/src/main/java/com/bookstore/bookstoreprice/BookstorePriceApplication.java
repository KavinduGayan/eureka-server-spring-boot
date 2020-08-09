package com.bookstore.bookstoreprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class BookstorePriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstorePriceApplication.class, args);
	}

}

@RestController
class Pricecontroller{
	@GetMapping("/prices")
	public ResponseEntity getPrices(){
		List<Book> priceList = new ArrayList<>(Arrays.asList(new Book("a", 100.0f),
				new Book("b", 500.0f),
				new Book("c", 250.0f)));
		return new ResponseEntity<>(priceList, HttpStatus.ACCEPTED);
	}
}

class Book {
	private String name;
	private float price;

	public Book() {
	}

	public Book(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
