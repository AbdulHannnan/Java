package com.crudAPI.REST.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crudAPI.REST.model.Product;
import com.crudAPI.REST.repository.ProductRepository;

/**
 * Seeds the in-memory database with a few products on startup so the API
 * returns data out of the box. Safe to delete in a real application.
 */
@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner seedProducts(ProductRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				repository.save(new Product("Laptop", "14-inch developer laptop", 1299.99, 10));
				repository.save(new Product("Wireless Mouse", "Ergonomic wireless mouse", 24.50, 100));
				repository.save(new Product("Mechanical Keyboard", "RGB mechanical keyboard", 89.00, 40));
			}
		};
	}
}
