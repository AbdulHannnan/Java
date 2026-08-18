package com.crudAPI.REST.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crudAPI.REST.exception.ResourceNotFoundException;
import com.crudAPI.REST.model.Product;
import com.crudAPI.REST.repository.ProductRepository;
import com.crudAPI.REST.service.ProductService;

/**
 * Default {@link ProductService} implementation backed by {@link ProductRepository}.
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	// Constructor injection — the preferred, testable form of DI.
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product create(Product product) {
		// Ensure a new row is created rather than an update.
		product.setId(null);
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
	}

	@Override
	public Product update(Long id, Product product) {
		Product existing = findById(id);
		existing.setName(product.getName());
		existing.setDescription(product.getDescription());
		existing.setPrice(product.getPrice());
		existing.setQuantity(product.getQuantity());
		return productRepository.save(existing);
	}

	@Override
	public void delete(Long id) {
		Product existing = findById(id);
		productRepository.delete(existing);
	}
}
