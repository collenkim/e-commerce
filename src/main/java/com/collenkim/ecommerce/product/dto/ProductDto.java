package com.collenkim.ecommerce.product.dto;

import com.collenkim.ecommerce.brand.domain.Brand;
import com.collenkim.ecommerce.category.domain.Category;
import com.collenkim.ecommerce.product.domain.Product;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public class ProductDto {

    @Setter
    @Getter
    public static class ReqAdd {

        private String sellerId;
        private String productCode;
        private Long brandId;
        private String productName;
        private String thumbnailUrl;
        private String contentImageUrl;
        private Long categoryId;
        private BigDecimal productPrice;
        private Integer productStock;
        private String description;

        public Product toEntity(Brand brand, Category category) {
            return Product.createProduct(sellerId, productCode, brand, productName, thumbnailUrl,
                contentImageUrl, category, productPrice, productStock, description);
        }
    }

}
