package com.collenkim.ecommerce.category.dto;

import com.collenkim.ecommerce.category.domain.Category;
import lombok.Getter;
import lombok.Setter;

public class CategoryDto {

    @Setter
    @Getter
    public static class ReqAdd {

        private Long parentId;
        private String categoryName;
        private String categoryIcon;
        private Integer level;

        public Category toEntity() {
            return Category.createCategory(parentId, categoryName, categoryIcon, level);
        }
    }

}
