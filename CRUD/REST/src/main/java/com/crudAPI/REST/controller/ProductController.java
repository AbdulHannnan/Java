package com.crudAPI.REST.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudAPI.REST.model.Product;
import com.crudAPI.REST.service.ProductService;

import jakarta.validation.Valid;

/**
 * REST endpoints for the Product resource.
 *
 * <pre>
 * POST   /api/products        create
 * GET    /api/products        list all
 * GET    /api/products/{id}   get one
 * PUT    /api/products/{id}   update
 * DELETE /api/products/{id}   delete
 * </pre>
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
		Product created = productService.create(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
		return ResponseEntity.ok(productService.update(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
