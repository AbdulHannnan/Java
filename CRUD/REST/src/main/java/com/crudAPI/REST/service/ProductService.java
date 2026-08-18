package com.crudAPI.REST.service;

import java.util.List;

import com.crudAPI.REST.model.Product;

/**
 * Business-logic contract for managing {@link Product} resources.
 * Controllers depend on this interface, not on a concrete implementation.
 */
public interface ProductService {

	Product create(Product product);

	List<Product> findAll();

	Product findById(Long id);

	Product update(Long id, Product product);

	void delete(Long id);
}
