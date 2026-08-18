package com.crudAPI.REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudAPI.REST.model.Product;

/**
 * Data-access layer for {@link Product}. Spring Data JPA generates the
 * implementation at runtime, giving CRUD methods (save, findById, findAll,
 * deleteById, ...) out of the box.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
