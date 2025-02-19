package com.collenkim.ecommerce.category.service.impl;

import com.collenkim.ecommerce.category.domain.Category;
import com.collenkim.ecommerce.category.dto.CategoryDto;
import com.collenkim.ecommerce.category.repository.CategoryRepository;
import com.collenkim.ecommerce.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 정보 조회
     *
     * @param categoryId
     * @return
     */
    @Override
    public Category getCategoryByCategoryId(Long categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }

    /**
     * 카테고리 정보 등록
     *
     * @param reqAdd
     */
    @Override
    public void insertCategory(CategoryDto.ReqAdd reqAdd) {
        Category category = reqAdd.toEntity();
        categoryRepository.save(category);
    }

}
