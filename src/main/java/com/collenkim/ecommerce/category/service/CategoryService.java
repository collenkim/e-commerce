package com.collenkim.ecommerce.category.service;

import com.collenkim.ecommerce.category.domain.Category;
import com.collenkim.ecommerce.category.dto.CategoryDto;

public interface CategoryService {

    /**
     * 카테고리 정보 조회
     *
     * @param categoryId
     * @return
     */
    Category getCategoryByCategoryId(Long categoryId);

    /**
     * 카테고리 정보 등록
     *
     * @param reqAdd
     */
    void insertCategory(CategoryDto.ReqAdd reqAdd);
}
