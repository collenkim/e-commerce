package com.collenkim.ecommerce.category.repository;

import com.collenkim.ecommerce.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryId(Long categoryId);
    
}
