package com.collenkim.ecommerce.product.repository;

import com.collenkim.ecommerce.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
